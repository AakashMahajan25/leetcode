class Solution {
    public void nextPermutation(int[] nums) {
        // Optimal Solution TC->O(N) SC->O(1)
        int breakpointIndex = -1;
        for (int i=nums.length-1; i>0; i--) {
            if (nums[i-1]<nums[i]) {
                breakpointIndex = i-1;
                break;
            }
        }
        if (breakpointIndex==-1) {
            int left = 0;
            int right = nums.length-1;
            while (right > left) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        } else {
            for (int i=nums.length-1; i>breakpointIndex; i--) {
                if (nums[i]>nums[breakpointIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[breakpointIndex];
                    nums[breakpointIndex] = temp;
                    break;
                }
            }
            int left = breakpointIndex+1;
            int right = nums.length-1;
            while (right > left) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        // Brute Force solution involves making a dictionary from each possible permutation and then fetching and it is too inefficient and will take a lot of time
        // TC->O(N!XN) 
    }
}