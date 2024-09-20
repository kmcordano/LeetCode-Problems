class Solution {
    public String shortestPalindrome(String s) {
        char[] reverse = new StringBuilder(s).reverse().toString().toCharArray();
        char[] sArray = s.toCharArray();

        int offset = 0;
        boolean done = true;
        do {
            done = true;

            for(int index = 0; index < reverse.length - offset; index++) {
                if(reverse[index + offset] != sArray[index]) {
                    done = false;
                    offset++;
                    break;
                }
            }
        }
        while(!done);

        return new String(reverse).substring(0, offset) + s;
    }
}