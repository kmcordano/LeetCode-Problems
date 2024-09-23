class Solution {
    private HashMap<String, Integer> memory;

    public int minExtraChar(String s, String[] dictionary) {
        memory = new HashMap<String, Integer>();

        return minimumExtraCharacters(s, dictionary);
    }

    private int minimumExtraCharacters(String s, String[] dictionary) {
        if(s.length() == 0) {
            return 0;
        }

        if(memory.containsKey(s)) {
            return memory.get(s);
        }

        int minChars = s.length();
        for(String compare : dictionary) {
            int startIndex = s.indexOf(compare);
            if(startIndex != -1) {
                int iterationMin = minimumExtraCharacters(s.substring(0, startIndex), dictionary) 
                    + minimumExtraCharacters(s.substring(startIndex + compare.length()), dictionary);
                if(iterationMin < minChars) {
                    minChars = iterationMin;
                }
            }
        }

        memory.put(s, minChars);

        return minChars;
    }
}