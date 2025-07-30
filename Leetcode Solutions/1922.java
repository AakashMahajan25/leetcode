class Solution {
    // TC->O(logn) SC->O(1)
    public int countGoodNumbers(long n) {
        int mod = 1_000_000_007;
        long even = (n + 1) / 2; 
        long odd = n / 2;        
        return (int) (power(5, even, mod) * power(4, odd, mod) % mod);
    }

    private long power(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}