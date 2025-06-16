class Solution {
    public int singleNonDuplicate(int[] nums) {
        // Optimal Approach TC->O(logN) SC->O(1)
       int n = nums.length;
       int low = 1;
       int high = nums.length-2;
       if (nums.length==1) return nums[0];
       if (nums[0]!=nums[1]) return nums[0];
       if (nums[n-2]!=nums[n-1]) return nums[n-1];
        while (low<=high) {
            int mid = (low + high)/2;
            if (nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]) {
                return nums[mid];
            } else if ((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid]==nums[mid+1])) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}