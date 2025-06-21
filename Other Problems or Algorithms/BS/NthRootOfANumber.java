class Solution {
    private long power(long base, int exp) {
        long result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
            if (result > Long.MAX_VALUE / base) return Long.MAX_VALUE; 
        }
        return result;
    }

    public int NthRoot(int N, int M) {
        long low = 1;
        long high = M;

        while (low <= high) {
            long mid = (low + high) / 2;
            long midPow = power(mid, N);

            if (midPow == M) {
                return (int) mid;
            } else if (midPow < M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; 
    }
}
