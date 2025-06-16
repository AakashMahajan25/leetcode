class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Optimal Approach: Using two binary searches TC->O(logn) SC->O(1)
        int[] answer = {-1, -1};
        int n = nums.length;
        int low = 0;
        int high = n-1;
        // Finding First Occurence
        while (low<=high) {
            int mid = (low + high)/2;
            if (nums[mid]==target) {
                answer[0] = mid;
                high = mid-1;
            } else if (nums[mid]>target) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        low = 0;
        high = n-1;
        // Finding Last Occurence
        while (low<=high) {
            int mid = (low + high)/2;
            if (nums[mid]==target) {
                answer[1] = mid;
                low = mid+1;
            } else if (nums[mid]>target) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return answer;


        // My Approach (Iterative) TC->O(N) as it is doing linear search when nums[mid]==target SC->O(1)
        // It will have this O(N) complexity when the array consists of target element only
        // int[] answer = new int[2];
        // int n = nums.length;
        // int low = 0;
        // int high = n-1;
        // while (low<=high) {
        //     int mid = (low + high)/2;
        //     if (nums[mid]==target) {
        //         int temp = mid;
        //         while (temp!=0 && nums[temp-1]==target) {
        //             temp--;
        //         }
        //         answer[0] = temp;
        //         temp = mid;
        //         while (temp!=(n-1) && nums[temp+1]==target) {
        //             temp++;
        //         }
        //         answer[1] = temp;
        //         return answer;
        //     } else if (nums[mid]>target) {
        //         high = mid-1;
        //     } else {
        //         low = mid+1;
        //     }
        // }
        // return new int[]{-1, -1};
    }
}