class Solution {
    public int minimumLength(String s) {
        int pre = 0;    // Prefix Pointer
        int suf = s.length() - 1;   // Suffix pointer
        char[] str = s.toCharArray();   // Char array for faster indexing

        /* Base case */
        if(str[pre] != str[suf]) {  // Break if string can't be minimized
            return s.length();
        }

        /* Minimize loop */
        char curChar = str[pre];    // Target char
        while(pre < suf) {
            while(pre < suf && str[pre] == curChar) {   // Iterate through prefix
                pre++;
            }

            if(pre == suf) {    // If the prefix caught the suffix, the full string can be removed
                return 0;
            }

            while(pre < suf && str[suf] == curChar) {   // Iterate through suffix
                suf--;
            }

            if(str[pre] == str[suf]) {  // After iteration, loop if char is the same
                curChar = str[pre];
            }
            else {  // Otherwise, the string is minimized
                return suf - pre + 1;   // + 1 for inclusive index
            }
        }

        /* Return 1 for the single remaining char */
        return suf - pre + 1;
    }
}