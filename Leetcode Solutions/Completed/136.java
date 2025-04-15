import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        // Most Optimal Approach using XOR Operation
        int XOROperation = 0;

        for (int i : nums) {
            XOROperation ^= i;
        }

        return XOROperation;



        // Better Approach using HashMap
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i=0; i<nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int key = entry.getKey();
        //     int value = entry.getValue();
        //     if (value == 1) {
        //         return key;
        //     }
        // }
        // return -1;
    
    
    // Better Approach using Sorting
    //    Arrays.sort(nums);
    //    for (int i=0; i<nums.length-1; i+=2) {
    //         if (nums[i]!=nums[i+1]) {
    //             return nums[i];
    //         }
    //    }
    //    return nums[nums.length-1];
    }
}