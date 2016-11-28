/* https://leetcode.com/problems/count-primes/ */
/*
Solution 1: Brute Force (O(n^2/2));
*/

public int countPrimes(int n) {
    int cnt = 0;
    for(int i = 1; i < n; i++) {
        cnt += isPrime(i) ? 1 : 0;
    }
    return cnt;
}

private boolean isPrime(int target) {
    if(target == 1) return false;
    if(target == 2) return true;
    for(int i = 2; i < target; i++) {
        if(target%i == 0) return false;
    }
    return true;
}

/*
Solution 2: Optimization:
for isPrime, we only need to count till sqrt(target);
*/

public int countPrimes(int n) {
    int cnt = 0;
    for(int i = 1; i < n; i++) {
        cnt += isPrime(i) ? 1 : 0;
    }
    return cnt;
}

private boolean isPrime(int target) {
    if(target == 1) return false;
    if(target == 2) return true;
    for(int i = 2; i*i <= target; i++) {
        if(target%i == 0) return false;
    }
    return true;
}

/*
Solution 3: Utilize the prime * # is not prime anymore to mark from
1*(3,4,5,6,7....) or 2*(2,3,4,5,6,7)
*/

public int countPrimes(int n) {

    if(n < 2) return 0;
    boolean[] dp =new boolean[n+1];
    Arrays.fill(dp, true);

    dp[0] = false;
    dp[1] = false;

    for(int i = 2; i <= n; i++) {
      int j = i;
      /* Here is the trick that i*j may exceed Integer.MAX_VALUE */
      while(i <= n / j) {
        dp[i*j] = false;
        j++;
      }
    }

    int cnt = 0;
    for(int i = 2; i < n; i++) {
      cnt += dp[i] ? 1 : 0;
    }

    return cnt;
}
