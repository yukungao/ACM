/**
 * @param A: A list of lists of integers
 * @return: An integer
 */
public int jump(int[] A) {
    // write your code here
    // The target is to everytime find the maxim range that current step
    // could cover

    if(A == null || A.length == 0) return 0;
    int step = 0;
    int curMax = 0;
    int nextMax = 0;
    int n = A.length;
    int i = 0;
    while(i < n) {
        // Could reach then break;
        if(curMax > n -1 ) break;

        // Find the nextMAX with in this (one) step
        while(i<= curMax) {
            nextMax = Math.max(nextMax, A[i] + i);
            i++;
        }

        // Need to move 1 step anyway.
        step++;
        curMax = nextMax;

    }
    return step;

}
}
