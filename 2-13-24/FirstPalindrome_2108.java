
public class FirstPalindrome_2108 {
   public static void main(String args[]) {
      String[] words = {"abc","car","ada","racecar","cool"};   
      System.out.println(new Solution().firstPalindrome(words));
   }
}

class Solution {
   public String firstPalindrome(String[] words) {
      int front = 0;   // Pointer to front char
      int back = -1;   // Pointer to back char
      boolean found = true;   // Bool indicating found
      
      for(String s : words) {
         front = 0;   // Start at the front
         back = s.length() - 1;   // Start at the end
         found = true;   // Assume every word is a palindrome until proven otherwise
      
         while(front < back && found) {   // Iteratively move through s, closing in on the center
            if(s.charAt(front) != s.charAt(back)) {   // If the characters at the pointers differ, it is not a palindrome
               found = false;
            }
         
            // Close in the pointers
            front++;
            back--;
         }
      
         // At the end of the loop, if the word is a palindrome, it will still be found == true
         if(found) {
            return s;
         }
      }
   
      // If no words in the array are palindromes, return ""
      return "";
   }
}