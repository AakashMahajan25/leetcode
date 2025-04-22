class Solution {
    public int maxSubArray(int[] nums) {
        // Optimal Solution TC->O(N) SC->O(1) (Uses Kadane's Algorithm)
        int max = Integer.MIN_VALUE;
        int sum = 0;
        // int start = -1;
        // int last = -1;
        for (int i=0; i<nums.length; i++) {
            if (sum<0) sum=0;
            // if (sum == 0) start=i;
            sum+=nums[i];
            if (sum>max) {
                max = sum;
                // last = i;
            }
        }
        return max;


        // Better Approach  TC->O(N^2) SC->O(1)  (Might also cause Time Limit Exceeded error for large use cases)
        // int max = Integer.MIN_VALUE;
        // for (int i=0; i<nums.length; i++) {
        //     int sum = 0;
        //     for (int j=i; j<nums.length; j++) {
        //         sum += nums[j];
        //         max = Math.max(max, sum);
        //     }
        // }
        // return max;

        // Brute Force Approach  TC->O(N^3) SC->O(1)  (Might give Time Limit Exceeded error for large use cases)
        // int max = Integer.MIN_VALUE;
        // for (int i=0; i<nums.length; i++) {
        //     for (int j=i; j<nums.length; j++) {
        //         int sum = 0;
        //         for (int k=i; k<j+1; k++) {
        //             sum += nums[k];
        //         }
        //         max = Math.max(max, sum);
        //     }
        // }
        // return max;
    }
}