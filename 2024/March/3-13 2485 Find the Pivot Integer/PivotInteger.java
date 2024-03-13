class Solution {
    public int pivotInteger(int n) {
        int pLeft = 1;
        int pRight = n;
        int sumLeft = pLeft;
        int sumRight = pRight;

        while(pLeft <= pRight) {
            if(pLeft == pRight) {
                if(sumLeft == sumRight) {
                    return pLeft;
                }
            }

            if(sumLeft < sumRight) {
                pLeft++;
                sumLeft += pLeft;
            }
            else {
                pRight--;
                sumRight += pRight;
            }
        }

        return -1;
    }
}