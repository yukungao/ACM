/* http://www.lintcode.com/en/problem/happy-number/ */

/*
  No trick, just need to implement as happy number definition
*/
public boolean isHappy(int n) {
        // Write your code here
        if(n < 0) return false;

        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        map.put(n, true);
        int num = n;

        while(num != 1) {
            num = getNextNumber(num);
            if(map.containsKey(num)) {
                return false;
            } else {
                map.put(num, true);
            }
        }

        return true;
    }

    private int getNextNumber(int n) {

        int sum = 0;

        while( n != 0) {
           sum += (n%10) * (n%10);
           n = n/10;
        }

        return sum;
    }
