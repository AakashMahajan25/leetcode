class Solution {
    public int smallestIndex(int[] nums) {
        // TC->O(N) SC->O(1)
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            int number = nums[i];
            while (number>0) {
                sum+=number%10;
                number/=10;
            }
            if (sum==i) {
                return i;
            }
        }
        return -1;
    }
}