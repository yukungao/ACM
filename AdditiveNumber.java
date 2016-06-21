/* https://leetcode.com/problems/additive-number/ */

/* Additive Number
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
*/

/* This problem could brute-force solve, like our human think process
We could implement iterative way or the recursive way, the recursive function's
decelerating is interesting */

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0) return false;
        /*
          Assume num.substring(0,i) is your fisrt adder,
          num.substring(i,j) is your next adder,
          you need to find adder1 + adder2 in the remaining (j,num.length())
        */
        for(int i = 1; i < num.length()-1 ; i++) {
          for(int j = i + 1; j < num.length()-2; j++) {
              String adder1 = num.substring(0,i);
              String adder2 = num.substring(i,j);
              if(adder1.length() > 1 && adder1.charAt(0) - '0' == 0) continue;
              if(adder2.length() > 1 && adder2.charAt(0) - '0' == 0) continue;
              if( dfs(j,adder1,adder2,num) ) {
                  return true;
              }
          }
        }
        return false;
    }


    // From start to the end of num, we need to search adder1 + adder2;
    public boolean dfs(int start, String adder1, String adder2, String num) {
        if(start == num.length()) return true;
          String adder3 = stringAdder2(adder1 , adder2);
          if(start + adder3.length() > num.length()) return false;
          String third = num.substring(start, start + adder3.length());
          if(!adder3.equals(third)) {
        	   //System.out.println("adder3 " + adder3 + " third " + third);
            return false;
          }
          return dfs(start + adder3.length(), adder2, adder3,num);
        }

        public String stringAdder(String adder1, String adder2){
            if(adder1 == null) return adder2;
            if(adder2 == null) return adder1;

            //Make sure the adder1 is longer One
            if(adder1.length() < adder2.length()) {
              String tmp = adder1;
              adder1 = adder2;
              adder2 = adder1;
            }

            int p1 = adder1.length() - 1 ;
            int p2 = adder2.length() - 1;
            int carry = 0;
            String res = "";

            while(p2 >= 0) {
               int sum = (int)(adder1.charAt(p1) - '0') + (int)(adder2.charAt(p2) - '0') + carry;
               res = String.valueOf(sum%10) + res;
               carry = sum/10;
               p2--;
               p1--;
            }

            while(p1 >= 0) {
              int sum = (int)(adder1.charAt(p1) - '0') + carry;
              res = String.valueOf(sum%10) + res;
              carry = sum/10;
              p1--;
            }

            if(carry == 1) {
              res = "1" + res;
            }

            return res;
        }


        public String stringAdder2(String adder1, String adder2){
            if(adder1 == null) return adder2;
            if(adder2 == null) return adder1;
            long a = Long.parseLong(adder1);
            long b = Long.parseLong(adder2);
            long res = a + b;
            return Long.toString(res);
        }

}
