class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        while (true) {
            s = s + s;
            if (s.contains(goal)) {
                return true;
            } else {
                return false;
            }
        }
    }
}