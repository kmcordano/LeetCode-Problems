class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        ArrayList<int[]> fractions = new ArrayList<int[]>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                fractions.add(new int[] {arr[i], arr[j]});
            }
        }

        Collections.sort(fractions, new Sorter());

        return fractions.get(k - 1);
    }
}

class Sorter implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return (a[0] * b[1]) - (b[0] * a[1]); 
    }
}