class Solution {
    // TC->O(logn) SC->O(1)
    public long floorSqrt(long n) {
        long low = 1;
        long high = n;
        long answer = 1;
        while (low <= high) {
            long mid = (low + high)/2;
            if (mid >  n/mid) {
                high = mid - 1;
            } else {
                answer = mid;
                low = mid+1;
            } 
        }
        return answer;
    }
}