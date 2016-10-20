/*http://www.lintcode.com/en/problem/reverse-integer/ */
/*
The trick part is to detect overflow:
by check if tmp/10 == res
*/
public int reverseInteger(int n) {
    // Write your code here
    int res = 0;

    while(n != 0) {
        int tmp = res*10 + n%10;
        //Detect the overflow by doing this
        if(tmp/10 != res) {
            return 0;
        }
        res = tmp;
        n = n/10;
    }

    return res;
}
