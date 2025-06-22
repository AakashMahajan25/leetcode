class Solution {
    // TC->O(Nlog(sumOfWeights)) SC->O(1)
    private int[] lowHigh(int[] weights, int n) {
        int low = Integer.MIN_VALUE;;
        int high = 0;
        for (int i=0; i<n; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }
        return new int[]{low, high};
    }
    private int numberOfDays(int[] weights, int weightLimit, int n) {
        int days = 0;
        int currentWeight = 0;
        for (int i=0; i<n; i++) {
            if (currentWeight + weights[i] > weightLimit) {
                days += 1;
                currentWeight = weights[i];
            } else {
                currentWeight += weights[i];
            }
        }
        if (currentWeight > 0) {
            days += 1;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int[] bounds = lowHigh(weights, n);
        int low = bounds[0], high = bounds[1];
        int answer = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int temp = numberOfDays(weights, mid, n);
            if (temp <= days) {
                answer = Math.min(answer, mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return answer;
    }
}