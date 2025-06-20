class Solution {
    // TC->O(2N*logN) SC->O(N)
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
    public int pairCounter(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i=low; i<=mid; i++) {
            while (right<=high && (long) nums[i] > 2L * nums[right]) right++;
            count += (right-(mid+1));
        }
        return count;
    }
    public int sorter(int[] nums, int low, int high) {
        int count = 0;
        if (low>=high) return 0;
        int mid = (low + high)/2;
        count += sorter(nums, low, mid);
        count += sorter(nums, mid+1, high);
        count += pairCounter(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n==1) return 0;
        int low = 0;
        int high = n-1;
        return sorter(nums, low, high);
    }
}