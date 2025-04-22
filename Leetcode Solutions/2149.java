class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Optimal Approach TC->O(N) SC->O(N)
        int pos = 0;
        int neg = 1;
        int[] answer = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) {
                answer[pos] = nums[i];
                pos+=2;;
            } else {
                answer[neg] = nums[i];
                neg+=2;
            }
        }
        return answer;

        // Brute Force Approach TC->O(2N) SC->O(N)
        // int[] pos = new int[nums.length/2];
        // int posIndex = 0;
        // int[] neg = new int[nums.length/2];
        // int negIndex = 0;
        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i]>0) {
        //         pos[posIndex] = nums[i];
        //         posIndex++;
        //     } else {
        //         neg[negIndex] = nums[i];
        //         negIndex++;
        //     }
        // }
        // for (int i=0; i<nums.length/2; i++) {
        //     nums[2*i] = pos[i];
        //     nums[2*i+1] = neg[i];
        // }
        // return nums;
    }
}