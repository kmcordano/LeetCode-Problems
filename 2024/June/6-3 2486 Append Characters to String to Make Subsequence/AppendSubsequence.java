class Solution {
    public int appendCharacters(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;
        char current;

        for(tPointer = 0; tPointer < t.length(); tPointer++) {
            current = t.charAt(tPointer);
            while(sPointer < s.length() && s.charAt(sPointer) != current) {
                sPointer++;
            }

            sPointer++;
            if(sPointer > s.length()) {
                return t.length() - tPointer;
            }
        }

        return 0;
    }
}