class Solution {
    // TC->O(Nlog(max-min)) SC->O(1)
    private int[] minMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
            if (arr[i]<min) {
                min = arr[i];
            }
        }
        return new int[]{min, max};
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n<(m*k)) return -1;
        if (n==1) return bloomDay[0];
        int days = -1;
        int[] bounds = minMax(bloomDay);
        int low = bounds[0], high = bounds[1];
        while (low <= high) {
            int mid = low + (high-low)/2;
            int count = 0;
            int bouquets = 0;
            for (int i=0; i<n; i++) {
                if (bloomDay[i]<=mid) {
                    count++;
                } else {
                    bouquets += count/k;
                    count = 0;
                }
            }
            bouquets += count / k;
            if (bouquets>=m) {
                days = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return days;
    }
}