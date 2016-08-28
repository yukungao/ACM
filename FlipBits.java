/* http://www.lintcode.com/en/problem/flip-bits/ */
// Know how to use mask to get a specific bit

public static int bitSwapRequired(int a, int b) {
    // write your code here
    int res = 0;
    // Use a mask and shift
    for(int i = 0; i < 32; i++) {
        int mask = 1 << i;
        if((mask & a) != (mask &b)) {
            res++;
        }
    }

    return res;
}
