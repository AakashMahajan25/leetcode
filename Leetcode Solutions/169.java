import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {
        // Optimal Approach TC->O(N) SC->O(1) (Uses Moore's Voting Algorithm)
        int element = -1;
        int freq = 0;
        // int verify = 0;
        for (int i=0; i<nums.length; i++) {
            if (freq==0) {
                element=nums[i];
                freq++;
            } else if (nums[i]==element) {
                freq++;
            } else {
                freq--;
            }
        }
        // To verify if majority element exists 
        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i]==element) verify++;
        // }
        // if (verify>nums.length/2) return element;
        // return -1;
       return element;



        // Better Approach TC->O(2N) SC->O(N)
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     if (entry.getValue()>(nums.length/2)) {
        //         return entry.getKey();
        //     }
        // }
        // return -1;



        // Brute Force Approach TC->O(N^2) SC->O(1)
        // for (int i=0;i<nums.length;i++) {
        //     int count = 1;
        //     for (int j=i+1;j<nums.length;j++) {
        //         if (nums[j]==nums[i]) count++;
        //     }
        //     System.out.print(count);
        //     if (count>nums.length/2) return nums[i];
        // }
        // return -1;
    }
}