class Solution {
    public int findMin(int[] nums) {
        // My Approach TC->O(logN) SC->O(1)
        int n = nums.length;
        int low = 0;
        int high = n-1;
        if (nums[low] <= nums[high]) return nums[low];
        while (low<=high) {
            int mid = low + (high - low) / 2;
            if (mid!=n-1 && nums[mid]>nums[mid+1]) {
                return nums[mid+1];
            }
            if (nums[low]<=nums[mid]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return nums[0];
    }
}