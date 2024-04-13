class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] scanned = new int[matrix[0].length];
        int scannedMax = 0;
        int max = 0;

        for(char[] row : matrix) {
            for(int i = 0; i < row.length; i++) {
                if(row[i] == '0') {
                    scanned[i] = 0;
                }
                else {
                    scanned[i] = scanned[i] + 1;
                }
            }

            scannedMax = findMax(scanned);
            max = (scannedMax > max) ? scannedMax : max;
        }

        return max;
    }

    private int findMax(int[] row) {
        int max = 0;
        
        int curVal;
        int iterMax;
        for(int i = 0; i < row.length; i++) {
            if(row[i] == 0) {
                continue;
            }


            curVal = row[i];
            iterMax = curVal;
            for(int left = i - 1; left >= 0; left--) {
                if(row[left] == 0) {
                    break;
                }
                else if(row[left] < curVal) {
                    break;
                }
                else {
                    iterMax += curVal;
                }
            }

            for(int right = i + 1; right < row.length; right++) {
                if(row[right] == 0) {
                    break;
                }
                else if(row[right] < curVal) {
                    break;
                }
                else {
                    iterMax += curVal;
                }
            }

            if(iterMax > max) {
                max = iterMax;
            }
        }

        return max;
    }
}