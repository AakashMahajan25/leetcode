class Solution {
    public int missingNumber(int[] nums) {

        int h_number = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>h_number) {
                h_number = nums[i];
            }
        }

        int answer = h_number+1;
        
        for (int i = 0; i <= h_number; i++) {
            
            boolean found = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j]==i) {
                    found = true;
                }}
            
            if (found==false) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}