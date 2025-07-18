class Solution {
    // Optimal Solution TC->O(N^2) SC->O(1)
    public int beautySum(String s) {
        int total = 0;

        for (int i=0; i<s.length(); i++) {
            int[] freq = new int[26];

            for (int j=i; j<s.length(); j++) {
                char c = s.charAt(j);
                freq[c-'a']++;

                int max = 0, min = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f>0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                
                total += (max-min);
            }
        }

        return total;
    }







    // Brute Force Solution TC->O(N^3) 
    // private int beautyCalculator(String s) {
    //     HashMap<Character, Integer> map = new HashMap<>();
    //     for (int i=0; i<s.length(); i++) {
    //         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
    //     }
    //     int most = Integer.MIN_VALUE, least = Integer.MAX_VALUE;
    //     for (int i : map.values()) {
    //         if (i > most) {
    //             most = i;
    //         } 
    //         if (i < least) {
    //             least = i;
    //         }
    //     }
    //     return most-least;
    // }
    // public int beautySum(String s) {
    //     int sum = 0;
    //     for (int i=0; i<s.length(); i++) {
    //         for (int j=i+1; j<=s.length(); j++) {
    //             sum += beautyCalculator(s.substring(i, j));
    //         }
    //     }
    //     return sum;
    // }
}