class Solution {
    public String largestOddNumber(String num) {
        // TC->O(N) SC->O(1)
        int n = num.length();
        int oddIndex = -1;
        for (int i=n-1; i>=0; i--) {
            int x = (int) num.charAt(i);
            if (x%2==1) {
                oddIndex = i;
                break;
            }
        }
        if (oddIndex==-1) return "";
        return num.substring(0, oddIndex+1);
    }
}