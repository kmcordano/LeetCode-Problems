import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    public static void main(String[] args) {
        String order = "cba";
        String s = "abcd";
        System.out.println(new Solution().customSortString(order, s));
    }
}

class Solution {
    public String customSortString(String order, String s) {
        Character[] str = new Character[order.length()];
        for(int i = 0; i < order.length(); i++) {
            str[i] = order.charAt(i);
        }

        HashMap<Character, Integer> priorityMap = new HashMap<Character,Integer>();
        int priority = 1;
        for(int i = str.length - 1; i >= 0; i--) {
            priorityMap.put(str[i], priority);
            priority++;
        }

        Arrays.sort(str, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return priorityMap.getOrDefault(b, 0) - priorityMap.getOrDefault(a, 0); 
            }
        });

        StringBuilder sb = new StringBuilder(str.length);
        for(Character c : str) {
            sb.append(c.charValue());
        }

        return sb.toString();
    }
}