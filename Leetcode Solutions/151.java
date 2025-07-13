class Solution {
    public String reverseWords(String s) {
        // My Solution TC->O(N) SC->O(1)
        String[] words = s.trim().split("\\s+");
        int n = words.length;
        StringBuilder str = new StringBuilder();
        for (int i=n-1; i>=0; i--) {
            str.append(words[i]);
            if (i==0) break;
            str.append(" ");
        }
        return str.toString();
    }
}