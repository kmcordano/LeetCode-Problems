public class OddBinNum {
    public static void main(String[] args) {
        System.out.println(new Solution().maximumOddBinaryNumber("0101"));
    }
}

class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] str = new char[s.length()];
        int p1 = 0;
        int p0 = str.length - 2;
        boolean first1 = true;
        
        for(char c : s.toCharArray()) {
            if(c == '1') {
                if(first1) {
                    str[str.length - 1] = '1';
                    first1 = false;
                }
                else { 
                    str[p1++] = '1';
                }
            }
            else {
                str[p0--] = '0';
            }
        }

        return new String(str);
    }
}