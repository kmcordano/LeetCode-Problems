class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int num0 = 0;
        int num1 = 0;

        for(int s : students) {
            if(s == 0) {
                num0++;
            }
            else {
                num1++;
            }
        }

        for(int s : sandwiches) {
            if(s == 0) {
                if(--num0 < 0) {
                    return num1;
                }
            }
            else {
                if(--num1 < 0) {
                    return num0;
                }
            }
        }

        return 0;
    }
}