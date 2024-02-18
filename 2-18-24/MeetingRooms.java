import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] meetings = {{0,10},{1,5},{2,7},{3,4}};
        System.out.println(new Solution().mostBooked(2, meetings));
    }    
}

class Solution {
    private PriorityQueue<MeetingEvent> events;
    private PriorityQueue<MeetingStart> waitlist;
    int[] meetingCount;
    boolean[] roomOpen;
    int timer;

    public int mostBooked(int n, int[][] scheduledMeetings) {
        /* Initialize rooms and tracking attributes */
        meetingCount = new int[n];
        roomOpen = new boolean[n];
        Arrays.fill(roomOpen, true);
        timer = 0;

        /* Initialize event queues */
        events = new PriorityQueue<MeetingEvent>(new MeetingEventComparator());
        waitlist = new PriorityQueue<MeetingStart>(new MeetingEventComparator());

        /* Push all scheduled meetings into queue */
        for(int[] meeting : scheduledMeetings) {
            events.offer(new MeetingStart(meeting[0], meeting[1] - meeting[0]));
        }

        /* Start event simulator */
        MeetingEvent nextEvent;
        while(!events.isEmpty()) {
            nextEvent = events.poll();  // Select next event
            timer = nextEvent.timeStamp();  // Update timer
            switch(nextEvent.type()) {
                case MEETING_START :    // If meeting start event
                    int roomNumber = nextVacantRoom();  
                    if(roomNumber != -1) {    // If a room is vacant, occupy it
                        occupyRoom(roomNumber, timer + nextEvent.duration());
                    }
                    else {  // Otherwise, join a prioritized waitlist
                        waitlist.offer((MeetingStart) nextEvent);
                    }
                    break;
                case MEETING_END :  // If meeting end event
                    vacateRoom(nextEvent.roomNumber());
                    break;
            }
        }

        /* Calculate return value */
        int max = 0;
        int maxRoomNum = -1;
        for(int roomNum = 0; roomNum < n; roomNum++) {
            System.out.print("Room " + roomNum + ": ");
            System.out.println(meetingCount[roomNum]);

            if(meetingCount[roomNum] > max) {
                max = meetingCount[roomNum];
                maxRoomNum = roomNum;
            }
        }

        return maxRoomNum;
    }

    private void vacateRoom(int roomNumber) {
        if(waitlist.isEmpty()) {
            roomOpen[roomNumber] = true;
        }
        else {  // If there are waitlisted meetings, allow them to occupy room
            MeetingStart e = waitlist.poll();
            occupyRoom(roomNumber, timer + e.duration());
        }
    }

    private void occupyRoom(int roomNumber, int meetingEndTime) {
        meetingCount[roomNumber] = meetingCount[roomNumber] + 1;
        roomOpen[roomNumber] = false;
        events.offer(new MeetingEnd(meetingEndTime, roomNumber));
    }

    private int nextVacantRoom() {
        for(int roomNumber = 0; roomNumber < roomOpen.length; roomNumber++) {
            if(roomOpen[roomNumber]) {
                return roomNumber;
            }
        }

        return -1;
    }
}

abstract class MeetingEvent {
    protected int timeStamp;
    protected int roomNumber;
    protected int duration;
    protected MeetingEventType type;

    public void timeStamp(int timeStamp) { this.timeStamp = timeStamp; }
    public void roomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    public int timeStamp() { return timeStamp; }
    public int roomNumber() { return roomNumber; }
    public int duration() { return duration; }
    public MeetingEventType type() { return type; }
}

class MeetingStart extends MeetingEvent {
    public MeetingStart(int startTime, int duration) {
        this.timeStamp = startTime;
        this.duration = duration;
        
        roomNumber = -1;
        type = MeetingEventType.MEETING_START;
    }

    public void duration(int duration) { this.duration = duration; }
    public int duration() { return duration; }
}

class MeetingEnd extends MeetingEvent {
    public MeetingEnd(int endTime, int roomNumber) {
        this.timeStamp = endTime;
        this.roomNumber = roomNumber;

        duration = 0;
        type = MeetingEventType.MEETING_END;
    }
}

class MeetingEventComparator implements Comparator<MeetingEvent> {
    public int compare(MeetingEvent a, MeetingEvent b) {
        return (
            // If different time stamp, sort by time stamp
            a.timeStamp() - b.timeStamp() == 0) ? (
                // If different types, sort by type
                (a.type().priority() - b.type().priority() == 0) ? (
                    //If different room numbers, sort by room number
                        a.roomNumber() - b.roomNumber()
                    ) : (
                        a.type().priority() - b.type().priority()
                    )
            ) : (
                a.timeStamp() - b.timeStamp()
            );
    }
}

enum MeetingEventType {
    MEETING_START(1),
    MEETING_END(0);

    private int priority;
    public int priority() { return priority; }
    MeetingEventType(int priority) {
        this.priority = priority;
    }
}