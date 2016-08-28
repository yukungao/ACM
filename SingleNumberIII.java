/* http://www.lintcode.com/en/problem/single-number-iii/# */
// The key part is to use different bit to divide these number into two groups

public List<Integer> singleNumberIII(int[] A) {
    // write your code here

    // Step 1, find the XOR of two different number
    List<Integer> res = new LinkedList<Integer>();
    if(A == null || A.length == 0) return res;

    int twoXorRes = 0;

    for(int i = 0; i < A.length ; i++) {
        twoXorRes ^= A[i];
    }

    // Pick the first different bit of two number from the left
    int mask = 0;

    for(int i = 0; i < 32; i++) {
        mask = 1 << i;
        if((mask & twoXorRes) != 0) {
            break;
        }
    }

    // Okay based on this mask
    int res1 = 0;
    int res2 = 0;

    for(int i = 0; i < A.length; i++) {
        if((A[i] & mask) != 0) {
            res1 ^= A[i];
        } else {
            res2 ^= A[i];
        }
    }

    res.add(res1);
    res.add(res2);

    return res;
}
