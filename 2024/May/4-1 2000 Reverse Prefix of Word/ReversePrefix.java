class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int left = 0;
        int right;
        for(right = 0; right < word.length(); right++) {
            if(arr[right] != ch) {
                continue;
            }

            char temp;
            while(left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            break;
        }

        return new String(arr);
    }
}