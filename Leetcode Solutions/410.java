import java.util.Arrays;
class Solution {
    // TC->O(N*log(sum-max)) SC->O(1)
    int numberOfSeperations(int[] nums, int maxSum) {
        int seperations = 1;
        int pages = 0;
        for (int i=0; i<nums.length; i++) {
            if (pages+nums[i] <= maxSum) {
                pages += nums[i];
            } else {
                seperations++;
                pages = nums[i];
            }
        }
        return seperations;
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while (low <= high) {
            int mid = low + (high-low)/2;
            int seperations = numberOfSeperations(nums, mid);
            if (seperations > k) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}