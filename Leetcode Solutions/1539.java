class Solution {
    // TC->O(logN) SC->O(1)
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while (low<=high) {
            int mid = low + (high - low)/2;
            if ((arr[mid]-(mid+1)) >= k) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return k+low;
    }
}