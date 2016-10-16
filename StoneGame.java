/* http://www.lintcode.com/en/problem/stone-game/# */
/*
典型的区间内dp问题.用memorizition就行. 但要注意这么几点
1. divide 简单，但是conquer的时候,如何conquer:
    (sums[end+1] - sums[start])<-- 最后的值 + dfs(start, k) <--  左 + dfs(k+1,end)<--右
2. sums[i] 是 [0,i), exclusive 的
*/
public int stoneGame(int[] A) {
		// Write your code here
		if(A == null || A.length <= 1) return 0;
		// Need to figure out whether we want inclusive or exclusive

		// dp[i][j] represent the minmum cost merge stone from i to j (inclusive)


		// sums[i] represent the sum between A[0]->A[i](exclusive)
		int[] sums = new int[A.length+1];

		sums[0] = 0;
		int size = A.length;
		for(int i = 1; i <= A.length; i++) {

				sums[i] = sums[i-1] + A[i-1];
		}

		int [][] dp = new int[size][size];

		for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
						if( i == j) {
								// That's because if we only have one stone, that
								// doesn't really need cost.
								dp[i][i] = 0;
						} else {
								dp[i][j] = Integer.MAX_VALUE;
						}
				}
		}


		return dfs(sums, A, dp, 0, size-1);

}

private int dfs(int[] sums, int[] A, int [][] dp, int start, int end) {

		if(dp[start][end] != Integer.MAX_VALUE) {
				return dp[start][end];
		}

		int res = Integer.MAX_VALUE;

		// why couldn't equal end, that's because we will use k+1;
		// Say if k== end, part 1 is same as part dfs, which doesn't divide the
		// sub problem. so we should use k strictly smaller than k.

		for(int k = start; k < end; k++) {

				int tmp = (sums[end+1] - sums[start]) + dfs(sums, A, dp, start, k) + dfs(sums, A, dp, k+1, end);

				res = Math.min(res, tmp);
		}
		dp[start][end] = res;
		return res;

}
