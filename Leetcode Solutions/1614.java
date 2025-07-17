class Solution {
    // TC->O(N) SC->O(1)
    public int maxDepth(String s) {
        int max=0, current=0;
        for (int i=0; i<s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(') {
                current++;
                max = Math.max(max, current);
            } else if (chr == ')') {
                current--;
            }
        }
        return max;
    }
}