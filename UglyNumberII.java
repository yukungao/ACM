/* https://leetcode.com/problems/ugly-number-ii/ */

/* The key point is the ugly # =
    math.min(
        previous ugly[p2] # x2,
        previous ugly[p3] # x3, <--- Selected
        previous ugly[p5] # x5
    ). If we get current ugly # from x3,that means
    next time we should look

    math.min(
        previous ugly[p2] # x2,
        previous ugly[p3+1] # x3,
        previous ugly[p5] # x5
    )
    ugly[p3+1] x3

    Another point is, we need to prune the duplicate, say we get
    6, which could from 3x2 or 2x3, thus we should increase both p2 and p3.
*/

public int nthUglyNumber(int n) {

    if(n == 1) return 1;
    int[] ugly = new int[n];
    ugly[0] = 1;

    int cnt = 1;
    int pt2 = 0;
    int pt3 = 0;
    int pt5 = 0;

    while(cnt < n) {
        int nextUgly = Math.min(ugly[pt5]*5, Math.min(ugly[pt2] * 2, ugly[pt3]*3));
        if (nextUgly == ugly[pt2] *2) pt2++;
        if (nextUgly == ugly[pt3] *3) pt3++;
        if (nextUgly == ugly[pt5] *5) pt5++;
        ugly[cnt] = nextUgly;
        cnt++;
    }

    return ugly[n-1];

}
