/* https://leetcode.com/problems/coin-change/ */
public int coinChange(int[] coins, int amount) {
       /*
           dp[i] = min(dp[i-k]) + 1, where 0< k < i and in coins
           if all the dp[i-k] is -1, then return -1
           Initialization: dp[s] = 1, where s is part of coins others are -1
       */

       if(coins == null || coins.length == 0) return -1;

       if(amount == 0) return 0;

       // Sort the coins so that we can do the
       Arrays.sort(coins);
       int [] dp = new int[amount+1];


       Arrays.fill(dp, Integer.MAX_VALUE);
       dp[0] = 0;
       for(int i = 1; i <= amount; i++) {

           for(int j = 0; j < coins.length; j++) {
               if(coins[j] <= i) {
                   dp[i] = Math.min(dp[i-coins[j]] , dp[i]);
               }
           }

           if(dp[i] == Integer.MAX_VALUE) {
               continue;
           }

           dp[i] = dp[i] + 1;
       }

       if(dp[amount] == Integer.MAX_VALUE) {
           return -1;
       } else {
           return dp[amount];
       }
   }
