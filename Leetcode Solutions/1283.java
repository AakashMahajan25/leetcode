class Solution {
    // TC->O(Nlog(arr[max])) SC->O(1)
    private int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }
    private int sumAfterDivide(int[] nums, int div) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += Math.ceil((double) nums[i] / div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int answer = -1;
        int low = 1;
        int high = max(nums);
        while (low <= high) {
            int mid = low + (high-low)/2;
            int sum = sumAfterDivide(nums, mid);
            if (sum <= threshold) {
                answer = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return answer;
    }
}