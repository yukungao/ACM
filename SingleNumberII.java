/* https://leetcode.com/problems/single-number-ii/ */
/*
Key point:
1. 对于每一个bit进行统计
2. 注意位运算的时候，最好能用括号给括起来
*/
public int singleNumberII(int[] A) {
    // write your code here

    if(A == null || A.length == 0) return 0;

    int res = 0;
    // For each bit,

    for(int i = 0; i < 32; i++) {

        int mask = 1 << i;

        int count = 0;

        for(int j = 0; j < A.length; j++){
            if( (A[j] & mask) != 0) {
                count++;
            }
        }
        res |= (count%3) << i;
    }

    return res;
}
