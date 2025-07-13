class Solution {
    // Optimal Approach TC->O(log(m*n)) SC->O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (matrix[mid/n][mid%n] == target) {
                return true;
            } else if (matrix[mid/n][mid%n] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // TC->O(m+logn) SC->O(1)
    // boolean search(int[] nums, int target) {
    //     int low = 0;
    //     int high = nums.length-1;
    //     while (low <= high) {
    //         int mid = low + (high-low)/2;
    //         if (nums[mid] == target) {
    //             return true;
    //         } else if (nums[mid] > target) {
    //             high = mid-1;
    //         } else {
    //             low = mid+1;
    //         }
    //     }
    //     return false;
    // }
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     for (int i=0; i<matrix.length; i++) {
    //         if (matrix[i][matrix[i].length-1] >= target) {
    //             return search(matrix[i], target);
    //         }
    //     }
    //     return false;
    // }
}