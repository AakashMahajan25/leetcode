class Solution {
    public int maxProfit(int[] prices) {
        // TC->O(N) SC->O(1)
        int min = prices[0];
        int profit = 0;
        int cost = 0; 
        for (int i=1; i<prices.length; i++) {
            cost = prices[i]-min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}