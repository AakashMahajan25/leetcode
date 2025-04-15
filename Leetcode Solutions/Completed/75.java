class Solution {
    public void sortColors(int[] nums) {
        // Optimal Approach TC->O(N) SC->O(1)   uses Dutch National Flag Algorithm a.k.a 3-pointer approach
        int low=0;
        int mid=0;
        int high=nums.length-1;
        int temp = 0;
        while (mid<=high && nums.length>1) {
            if (nums[mid]==0) {
                temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            } else if (nums[mid]==1) {
                mid++;
            } else if (nums[mid]==2) {
                temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }


        // Better Approach TC->O(2N) SC->O(1)
        // int zeroes = 0;
        // int ones = 0;
        // int twos = 0;
        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i]==0) zeroes++;
        //     else if (nums[i]==1) ones++;
        //     else if (nums[i]==2) twos++;
        // }
        // for (int i=0; i<zeroes; i++) {
        //     nums[i]=0;
        // }
        // for (int i=zeroes; i<zeroes+ones; i++) {
        //     nums[i]=1;
        // }
        // for (int i=zeroes+ones; i<zeroes+ones+twos; i++) {
        //     nums[i]=2;
        // }
    }
}