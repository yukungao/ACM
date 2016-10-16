/*

Solution 1: To use a minHeap every time poll the smallest into the result,
and call the smallest * primes[i] to get further candidate
However, this time consumption is o(n*k*log(heapsize) <-- Insert time complexity
Of cause it will cause TLE
*/

public int nthSuperUglyNumber(int n, int[] primes) {

        if(primes == null || primes.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.offer(1);
        TreeSet<Integer> res = new TreeSet<Integer>();

        while(res.size() < n) {
            int ugly = minHeap.poll();
            if(res.contains(ugly)) continue;
            res.add(ugly);
            for(int i = 0; i < primes.length; i++) {
                minHeap.offer(primes[i] * ugly);
            }
        }

        return res.last();

    }

/*
Solution 2: Similiar to Ugly Number II, here we need to use
idx[i] to store for primitive[i], what's the current index.

Then we calculate nextCandidate by Math.min(res[idx[i]]*primitive[i]) And
remove duplicate, better write a subfunction to do it.
*/
public int nthSuperUglyNumber(int n, int[] primes) {
    /*

    Solution 1: To use a minHeap every time poll the smallest into the result,
    and call the smallest * primes[i] to get further candidate
    However, this time consumption is o(n*k*log(heapsize) <-- Insert time complexity

    */

    if(primes == null || primes.length == 0) return 0;
    int k = primes.length;

    int [] idx = new int[k];
    int [] res = new int[n];
    res[0] = 1;

    for(int i = 1; i < n; i++) {
        int nextUgly = findMinmum(idx, res, primes);
        res[i] = nextUgly;
    }

    return res[n-1];
}

private int findMinmum(int[] idx, int[] res, int[] primes) {
    int nextUgly = Integer.MAX_VALUE;
    int nextIndex = -1;
    int k = primes.length;
    // Need to store the next candidate index for further increase;
    for(int i = 0; i < k; i++) {
        int tmp = res[idx[i]] * primes[i];
        //Keep the first found one.
        if(tmp < nextUgly) {
            nextUgly = tmp;
            nextIndex = i;
        }
    }
    // Remove the duplicate
    for(int i = 0; i < k; i++) {
        int tmp = res[idx[i]] * primes[i];
        if (i != nextIndex && tmp == nextUgly) {
            idx[i]++;
        }
    }
    idx[nextIndex] = idx[nextIndex] + 1;
    return nextUgly;
}
/*
Solution 3: We can also do onelevel abstraction and use minHeap to replace
findMinmum function. Which give us minmum for free
*/
