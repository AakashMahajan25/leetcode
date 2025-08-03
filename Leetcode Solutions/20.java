class Solution {
    public boolean isValid(String s) {
        // TC->O(N) SC->O(N)
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
                continue;
            } else if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char top = st.pop();
                    if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                        return false;
                    } else {
                        continue;
                    }
                }
            }
        }
        return st.isEmpty();
    }
}