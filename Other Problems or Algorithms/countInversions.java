import java.util.ArrayList;
class Solution {
    public int merge(int[] nums, int low, int mid, int high) {
        // TC->Nlog2(N) SC->O(N)
        int count = 0
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
                count += (mid - left + 1);
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
        return count;
    }
    public void sorter(int[] nums, int low, int high) {
        int count = 0;
        if (low>=high) return;
        int mid = (low + high)/2;
        count += sorter(nums, low, mid);
        count += sorter(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        return count;
    }
    public int mergeSort(int[] nums) {
        int n = nums.length;
        if (n==1) return nums;
        int low = 0;
        int high = n-1;
        return sorter(nums, low, high);
    }
}