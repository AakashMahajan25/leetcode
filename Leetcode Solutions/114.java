class Solution {
    // TC->O(S) SC->O(1), where S is sum of length of all strings
    public String longestCommonPrefix(String[] strs) {
        for (int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j=1; j<strs.length; j++) {
                if (i>=strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}