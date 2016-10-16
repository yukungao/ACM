/* http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-ii/ */
// Greedyly to pick the value.
public int maxProfit(int[] prices) {
    // write your code here
    if(prices == null || prices.length == 0) return 0;

    // Greedy to pick the profit
    int profit = 0;
    for(int i = 1; i < prices.length; i++) {
        profit += Math.max(prices[i] - prices[i-1],0);
    }

    return profit;
}
