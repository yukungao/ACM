
public class StoneGame {

	    public int stoneGame(int[] A) {
	        if (A == null || A.length == 0) {
	            return 0;
	        }

	        int n = A.length;

	     	int[][] dp = new int[n][n];
	        int[][] visit = new int[n][n];

	        for (int i = 0; i < n; i++) {
	            dp[i][i] = 0;
	        }

	        // Initialize sum
	        int[][] sum = new int[n][n];
	        for (int i = 0; i < n; i++) {
	            sum[i][i] = A[i];
	            for (int j = i + 1; j < n; j++) {
	                sum[i][j] = sum[i][j - 1] + A[j];
	            }
	        }

	        return dfs(0, n-1, dp, visit, sum);
	    }

	    private int dfs(int i, int j, int[][] dp, int[][] visit, int[][] sum) {
	        //Done before, return
	        if(visit[i][j] == 1) return dp[i][j];

	        // Done
	        if(i == j) {
	            visit[i][j] = 1;
	            return dp[i][j];
	        }

	        dp[i][j] = Integer.MAX_VALUE;

	        // Recursive search
	        for (int k = i; k < j; k++) {
	            dp[i][j] = Math.min(dp[i][j], dfs(i, k, dp, visit, sum) + dfs(k + 1, j, dp, visit, sum) + sum[i][j]);
	        }
	        visit[i][j] = 1;
	        return dp[i][j];
	    }
}



public class Solver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoneGame stoneGame = new StoneGame();
		int [] testCase = {4,4,5,9};
		System.out.println(stoneGame.stoneGame(testCase));
	}

}
