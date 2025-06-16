class Solution {
    // Recursive Approach TC->O(logn) SC->O(1)
    public int recursiveSearch(int[] nums, int low, int high, int target) {
        if (low>high) return -1;
        int mid = (low + high)/2;
        if (nums[mid]==target) {
            return mid;
        } else if (nums[mid]>target) {
            return recursiveSearch(nums, low, mid-1, target);
        } else {
            return recursiveSearch(nums, mid+1, high, target);
        }
    }
    public int search(int[] nums, int target) {
        if (nums.length==1) {
            if (nums[0]==target) {
                return 0;
            }
        }
        return recursiveSearch(nums, 0, nums.length-1, target);




    // Iterative Approach TC->O(logn) SC->O(1)
    //    if (nums.length==1) {
    //     if (nums[0]==target) {
    //         return 0;
    //     }
    //    }

    //    int low = 0;
    //    int high = nums.length-1;
    //    while (low<=high) {
    //     int mid = (low+high)/2;
    //     if (nums[mid]==target) {
    //         return mid;
    //     } else if (nums[mid]>target) {
    //         high = mid-1;
    //     } else {
    //         low = mid+1;
    //     }
    //    }
    //    return -1; 
    }
}