import java.util.HashMap;
class Solution {
    public int minDeletion(String s, int k) {
        int uniqueElements = 0;
        int frequency = 0;
        int deletions = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int freq = map.getOrDefault(c, 0);
            if (freq==0) {
                map.put(c, 1);
                uniqueElements++;
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        while (uniqueElements > k) {
            for (Character key : map.keySet()) {
                if (map.get(key)==frequency) {
                    s = s.replace(String.valueOf(key), "");
                    deletions+=map.get(key);
                    uniqueElements--;
                }
                if (uniqueElements <= k) {
                    break;
                }
            }
            frequency++;
        }
        return deletions;
    }
}