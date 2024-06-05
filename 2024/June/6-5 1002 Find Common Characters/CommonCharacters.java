class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> str;
        ArrayList<String> intersection = new ArrayList<String>();
        
        for(String s : words[0].split("")) {
            intersection.add(s);
        }

        for(int i = 1; i < words.length; i++) {
            str = new ArrayList<String>(intersection);
            intersection.clear();

            for(String s : words[i].split("")) {
                if(str.remove(s)) {
                    intersection.add(s);
                }
            }
        }

        return intersection;
    }
}