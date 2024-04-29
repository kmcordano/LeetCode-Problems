public class FreedomTrail {
    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        System.out.println(new Solution().findRotateSteps(ring, key));
    }
}

class Solution {
    private ListNode head;

    public int findRotateSteps(String ring, String key) {
        initializeLinkedList(ring);
        return exploreKey(key, head);
    }

    private int exploreKey(String key, ListNode node) {
        int steps = 0;
        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);

            int right = stepsRight(node, c);
            int left = stepsLeft(node, c);
            if(left < right) {
                steps += left;
                for(int j = 0; j < left; j++) {
                    node = node.back;
                }
            }
            else if(right < left) {
                steps += right;
                for(int j = 0; j < right; j++) {
                    node = node.front;
                }
            }
            else {
                steps += left + 1;
                ListNode leftNode = node;
                ListNode rightNode = node;
                for(int j = 0; j < left; j++) {
                    leftNode = leftNode.back;
                }
                for(int j = 0; j < right; j++) {
                    rightNode = rightNode.front;
                }
                return steps + Math.min(exploreKey(key.substring(i+1), leftNode),
                                exploreKey(key.substring(i+1), rightNode));
            }

            steps++;
        }

        return steps;
    }

    private int stepsLeft(ListNode node, char target) {
        int steps = 0;
        while(node.val != target) {
            steps++;
            node = node.back;
        }
        return steps;
    }

    private int stepsRight(ListNode node, char target) {
        int steps = 0;
        while(node.val != target) {
            steps++;
            node = node.front;
        }
        return steps;
    }

    private void initializeLinkedList(String ring) {
        head = null;
        ListNode node;
        ListNode previous = null;
        boolean firstNode = true;

        // Set up double linked list
        for(char c : ring.toCharArray()) {
            node = new ListNode(c);
            node.back = previous; 
            if(firstNode) {
                head = node;   
                firstNode = false; 
            }
            else{
                previous.front = node;
            }
            previous = node;
        }
        previous.front = head;
        head.back = previous;
    }
}

class ListNode {
    public char val;
    public ListNode front;
    public ListNode back;

    public ListNode(char val) {
        this.val = val;
    }
}