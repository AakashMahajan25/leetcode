class Solution {
    public int maxArea(int[] height) {
        // Optimal Approach TC->O(N) SC->O(1)
        int i = 0;
        int j = height.length-1;
        int currentArea = 0;
        int maxArea = 0;
        while (i<j) {
            currentArea = Math.min(height[i], height[j]) * (j-i);
            if (currentArea>maxArea) maxArea=currentArea;
            if (height[i]>height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;


        // Brute Force Approach TC->O(N^2) SC->O(1)
        // int max = 0;
        // for (int i=0; i<height.length; i++) {
        //     for (int j=i+1; j<height.length; j++) {
        //         int area = Math.min(height[i], height[j]) * (j-i);
        //         if (area>max) max=area;
        //     }
        // }
        // return max;   
    }
}