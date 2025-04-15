class Solution {
    public int numberOfChild(int n, int k) {
        int period = 2*(n-1);
        k%=period;
        if (k<n) {
            return k;
        } else {
            return period-k;
        }
    }
}