class Solution {
    public int maxProfitTwoPointer(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }

    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minBuy);
            minBuy = Math.min(minBuy, price);
        }

        return maxProfit;
    }
}
