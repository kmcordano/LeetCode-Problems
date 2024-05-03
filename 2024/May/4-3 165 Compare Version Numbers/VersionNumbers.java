class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int i;
        for(i = 0; i < v1.length && i < v2.length; i++) {
            int r1 = Integer.valueOf(v1[i]);
            int r2 = Integer.valueOf(v2[i]);

            if(r1 == r2) {
                continue;
            }
            if(r1 < r2) {
                return -1;
            }
            if(r1 > r2) {
                return 1;
            }
        }

        if(v1.length == v2.length) {
            return 0;
        }

        if(v1.length > v2.length) {
            for(i = i; i < v1.length; i++) {
                if(Integer.valueOf(v1[i]) != 0) {
                    return 1;
                }
            }
        }
        else {
            for(i = i; i < v2.length; i++) {
                if(Integer.valueOf(v2[i]) != 0) {
                    return -1;
                }
            }
        }

        return 0;
    }
}