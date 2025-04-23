import java.util.HashSet;
class Solution {
    public int longestConsecutive(int[] nums) {
        // Optimal Solution TC->O(2N) SC->O(N)
        if (nums.length==0) return 0;
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        for (int elem : set) {
            if (!set.contains(elem-1)) {
                int count = 1;
                int number = elem;
                while (set.contains(number+1)) {
                    count++;
                    number++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;


        // Better Approach TC->O(NlogN) SC->O(1)
        // if (nums.length==0) return 0;
        // int count = 1;
        // int longest = 1;
        // Arrays.sort(nums);
        // int lastSmallest = nums[0];
        // for (int i=1; i<nums.length; i++) {
        //     if (nums[i] == lastSmallest) {
        //         continue;
        //     } else if (nums[i] == lastSmallest+1) {
        //         count++;
        //         longest = Math.max(longest, count);
        //         lastSmallest++;
        //     } else {
        //         count =  1;
        //         lastSmallest = nums[i];
        //     }
        // }
        // return longest;


        // My Approach TC->O(N^2) SC->O(N) (Will cause TLE Error)
        // int sequence = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<nums.length; i++) {
        //     map.put(nums[i], 1);
        // }
        // for (int i=0; i<nums.length; i++) {
        //     int key = nums[i];
        //     int count = 0;
        //     while (map.containsKey(key)) {
        //         count++;
        //         key++;
        //         sequence = Math.max(sequence, count);
        //     }
        // }
        // return sequence;
    }
}