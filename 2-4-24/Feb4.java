import java.util.HashMap;

public class Feb4 {
   public static void main(String args[]){
      Solution out = new Solution();
      String s = "ADOBECODEBANC";
      String t = "ABC";

      System.out.println(out.minWindow(s, t));
   }
}

class Solution {
   public String minWindow(String s, String t) {
      String sol = "";
      HashMap<String, Integer> secondaryString = new HashMap<String, Integer>();

      String cur = "";
      for(int i = 0; i < t.length(); ++i) {
         cur = t.substring(i, i+1);

         if(secondaryString.putIfAbsent(cur, 1) != null) {
            secondaryString.put(cur, secondaryString.get(cur) + 1);
         }
      }

      int startIndex = 0;
      int endIndex = 0;
      String curSolution = "";

      while(endIndex < s.length()) {
         if(!secondaryString.containsKey(s.substring(endIndex, endIndex+1))){
            startIndex = endIndex + 1;
         }
         else if(endIndex - startIndex > curSolution.length()) {
            
         }

         endIndex++;
      }

      return sol;
   }
}
