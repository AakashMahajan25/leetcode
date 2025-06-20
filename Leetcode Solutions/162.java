class Solution {
    public int findPeakElement(int[] nums) {
        // Optimal Approach TC->O(logN) SC->O(1)
        int n = nums.length;
        int low = 1;
        int high = n-2;
        if (n==1) return 0;
        if (nums[0]>nums[1]) return 0;
        if (nums[n-1]>nums[n-2]) return n-1;
        while (low<=high) {
            int mid = (low + high)/2;
            if (nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) {
                return mid;
            } else if (nums[mid-1]<nums[mid]) {
                low = mid+1;
            } else if (nums[mid]>nums[mid+1]) {
                high = mid-1;
            } else { // Means both high and low are stuck in troughs, just get one out to avoid infinite loop
                low = mid+1;
            }
        }
        return -1;
    }
}