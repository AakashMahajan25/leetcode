import java.util.HashMap;
class Solution {
    // My Solution TC->O(N^2) (containsValue runs on O(N)) SC->O(N)
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int n = s.length();
        for (int i=0; i<n; i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == t.charAt(i)) continue;
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            }
            else {
                return false;
            }
        }
        return true;
    }
}