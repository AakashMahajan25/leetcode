class Solution {
    public String removeOuterParentheses(String s) {
        // My Solution TC->O(N) SC->O(N)
        StringBuilder str = new StringBuilder();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c=='(') {
                if (depth>0) {
                    str.append(c);
                }
                depth++;
            } else {
                depth--;
                if (depth>0) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }
}