/* http://www.lintcode.com/en/problem/post-office-problem/ */

/*
O(n^3) time complexity

*/

/*
Tradition DP problem

 dp[i][j] means for the  1->j valleys, we build i to make sure the distance is
 smallest.

 The transfer function is:
 dp[i][j] = Math.min(dp[i-1][k], cost[k+1][j]) where k = i+1 ~ j-1;
 where the cost[k+1][j] is the cost to build 1 post office between k+1 -> j

 Initialization:
 dp[i][i] = 0;

*/

public int postOffice(int[] A, int k) {
    // Write your code here


    /*
    Tradition DP problem

     dp[i][j] means for the  1->j valleys, we build i to make sure the distance is
     smallest.

     The transfer function is:
     dp[i][j] = Math.min(dp[i-1][k], cost[k+1][j]) where k = 0 ~ j-1;
     where the cost[k+1][j] is the cost to build 1 post office between k+1 -> j

     Initialization:
     dp[i][i] = 0;

    */

    /*
    需要注意的点:
    1. k 的取值范围是 0~j-1
    2. 假如只建一个, 取meidan保证距离最小.

    */
    if(A == null || A.length == 0 || A.length <= k) {
        return 0;
    }

    Arrays.sort(A);

    int size = A.length;
    int [][] dp = new int [k+1][size+1];

    // Create the cost
    int [][] cost = new int [size+1][size+1];

    for(int i = 1; i <= size; i++) {
        for(int j = i; j <= size; j++) {

            int diff = 0;
            int mid = (i+j)/2;

            for(int q = i; q <= j; q++) {
                diff += Math.abs(A[q-1] - A[mid-1]);
            }
            cost[i][j] = diff;
        }
    }
    int sum = 0;
    for(int i = 0; i < size; i++) {
        sum += A[i];
    }
    // Initialization

    for(int i = 0; i <= k; i++) {
        for(int j = i; j <= size; j++) {
            if(j == i) {
                dp[i][j] = 0;
                continue;
            } else {
                dp[i][j] = sum;
            }
        }
    }

    // Transfer
    for(int i = 1; i <= k; i++) {
        for(int j = i; j <= size; j++) {
            for(int q = 0; q <= j -1 ; q++) {
                dp[i][j] = Math.min(dp[i][j], dp[i-1][q] + cost[q+1][j] );
            }
        }
    }

    return dp[k][size];
}
