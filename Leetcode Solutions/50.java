class Solution {
    // TC->O(logn) SC->O(logn)
    private double powerCalculator(double x, long n) {
        if (n==0) return (double) 1;
        if (n==1) return x;
        if (n<0) {
            x=1/x;
            n=-n;
        }
        if (n%2==0) {
            return powerCalculator(x*x, n/2);
        }
        return x*powerCalculator(x, n-1);
    }
    public double myPow(double x, int n) {
        return powerCalculator(x, (long) n);
    }
}