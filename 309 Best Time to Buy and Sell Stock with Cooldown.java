class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        // up to now profit ends with buy
        int[] buyProfit = new int[prices.length];
        // up to now profit ends with sell
        int[] sellProfit = new int[prices.length];
        
        buyProfit[0] = -prices[0];
        buyProfit[1] = Math.max(-prices[0], -prices[1]);
        sellProfit[0] = 0;
        sellProfit[1] = Math.max(0, buyProfit[0] + prices[1]);
        
        for (int i = 2; i < prices.length; i++) {
            // maximum profit of do nothing or buy again based on the sellProfit at/before day i-2
            buyProfit[i] = Math.max(buyProfit[i - 1], sellProfit[i - 2] - prices[i]);
            // maximum profit of do nothing or sell the stock based on buyProfit at/before day i-1
            sellProfit[i] = Math.max(sellProfit[i - 1], buyProfit[i - 1] + prices[i]);
        }
        
        return sellProfit[prices.length - 1];
    }
}