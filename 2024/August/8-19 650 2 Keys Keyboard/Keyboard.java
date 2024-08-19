class Solution {
    private static Map<Integer, Integer> baseCases = Map.of(
        Integer.valueOf(1), Integer.valueOf(0),
        Integer.valueOf(2), Integer.valueOf(2),
        Integer.valueOf(3), Integer.valueOf(3)
    );

    public int minSteps(int n) {
        if(baseCases.get(n) != null) {
            return baseCases.get(n);
        }

        int nextFactor = findLargestFactor(n);
        int nextFactorCount = minSteps(nextFactor);

        return nextFactorCount + (n / nextFactor);
    }

    public int findLargestFactor(int n) {
        int factor = 1;

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                if(i != n) {
                    factor = (i > factor) ? i : factor;
                }

                int div = n / i;
                if(div != i && div != n) {
                    factor = div > factor ? div : factor;
                }
            }
        }

        return factor;
    }   
}