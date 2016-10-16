/* http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/ */

public int maxProfit(int[] prices) {
    // write your code here
    // The method is to find the mindata before current node
    // and calculate the difference

    if(prices == null || prices.length ==0) return 0;

    int min = prices[0];
    int profit = 0;

    for(int i = 1; i < prices.length; i++) {
        profit = Math.max( profit, prices[i] - min);
        min = Math.min(min, prices[i]);
    }

    return profit;

}
