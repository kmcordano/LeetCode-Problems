class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
        String[] answer = new String[score.length];

        for(int i = 0; i < score.length; i++) {
            indexes.put(score[i], i);
        }

        Arrays.sort(score);

        int place = 1;
        for(int i = score.length - 1; i >= 0; i--) {
            String str = "";
            switch(place) {
                case 1:
                    str = "Gold Medal";
                    break;
                case 2:
                    str = "Silver Medal";
                    break;
                case 3:
                    str = "Bronze Medal";
                    break;
                default:
                    str = String.valueOf(place);
                    break;
            }
        
            answer[indexes.get(score[i])] = str;
            place++;
        }


        return answer;
    }
}