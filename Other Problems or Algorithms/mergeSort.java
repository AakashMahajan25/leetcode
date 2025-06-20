import java.util.ArrayList;
class Solution {
    public void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while (left<=mid && right<=high) {
            if (nums[left]<nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }
        while (left<=mid) {
            list.add(nums[left]);
            left++;
        }
        while (right<=high) {
            list.add(nums[right]);
            right++;
        }
        for (int i=low; i<=high; i++) {
            nums[i] = list.get(i-low);
        }
    }
    public void sorter(int[] nums, int low, int high) {
        if (low>=high) return;
        int mid = (low + high)/2;
        sorter(nums, low, mid);
        sorter(nums, mid+1, high);
        merge(nums, low, mid, high);
    }
    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n==1) return nums;
        int low = 0;
        int high = n-1;
        sorter(nums, low, high);
        return nums;
    }
}