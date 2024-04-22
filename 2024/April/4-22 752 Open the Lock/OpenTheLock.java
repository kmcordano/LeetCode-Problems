import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.Queue;

public class OpenTheLock {
   public static void main(String[] args) {
      String[] deadends = {"0201","0101","0102","1212","2002"};
      System.out.println(new Solution().openLock(deadends, "0202"));
   }
}

class Solution {
    private HashMap<String, HashSet<String>> tree;
    private HashMap<String, Integer> length;

    public int openLock(String[] deadends, String target) {
        tree = new HashMap<String, HashSet<String>>();
        length = new HashMap<String, Integer>();
        HashSet<String> de = new HashSet<String>();
        
        for(String s : deadends) {
            de.add(s);
        }

        Queue<String> toVisit = new ArrayDeque<String>();
        tree.put("0000", new HashSet<String>());
        length.put("0000", 0);
        toVisit.offer("0000");

        String current;
        while(!toVisit.isEmpty()) {
            current = toVisit.poll();

            if(current.equals(target)) {
                return length.get(current);
            }

            if(!de.contains(current)) {
                connectNeighbors(current);
            }
        } 

        return -1;   
    }
    
    private void connectNeighbors(String current) {
        String prefix;
        String suffix;
        String c;
        int cUp, cDown;
        for(int i = 0; i < 4; i++) {
            prefix = current.substring(0,i);
            c = String.valueOf(current.charAt(i));
            suffix = current.substring(i+1);

            cUp = Integer.valueOf(c) + 1;
            cDown = Integer.valueOf(c) - 1;
            if(cUp > 9) {
                addEdge(current, prefix + "0" + suffix, length.get(current) + 1);
            }
            else {
                addEdge(current, prefix + cUp + suffix, length.get(current) + 1);
            }

            if(cDown < 0) {
                addEdge(current, prefix + "9" + suffix, length.get(current) + 1);
            }
            else {
                addEdge(current, prefix + cDown + suffix, length.get(current) + 1);
            }
        }
    }

    private void addEdge(String from, String to, int len) {
        if(!tree.containsKey(to)) {
            tree.put(to, new HashSet<String>());
            length.put(to, len);
        }
        else if(length.get(to) > len) {
            length.put(to, len);
        }
    }
}