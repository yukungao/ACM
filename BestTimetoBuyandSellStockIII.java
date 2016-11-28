/* http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iii/# */

public int maxProfit(int[] prices) {
    // write your code here

    // Forward wise: dp1[i] is the profit before i
    // Backward wise: dp2[i] is the profit after i

    if(prices == null || prices.length == 0) return 0;
    int size = prices.length;

    int[] dp1 = new int[size];
    int[] dp2 = new int[size];

    int profit = 0;
    int min = prices[0];
    dp1[0] = 0;
    for(int i = 1; i < size; i++) {
        profit = Math.max(profit, prices[i] - min);
        min = Math.min(min, prices[i]);
        dp1[i] = profit;
    }


    profit = 0;
    int max = prices[size-1];
    dp2[size-1] = 0;

    for(int i = size - 2; i >= 0; i--) {
        profit = Math.max(profit, max - prices[i]);
        max = Math.max(max, prices[i]);
        dp2[i] = profit;
    }

    int res = 0;
    for(int i = 0; i < size; i++) {
        res = Math.max(res, dp1[i] + dp2[i]);
    }

    return res;
}
