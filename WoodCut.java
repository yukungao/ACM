/* http://www.lintcode.com/en/problem/wood-cut/# */
/* A very interesting binary search problem */

public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0) return 0;
        // Get the max length and use it.
        int start = 1;
        int end = -1;
        for(int i = 0; i < L.length; i++) {
          end = Math.max(end,L[i]);
        }

        while(start + 1 < end) {
          int mid = start + (end -start)/2;
          if(count(L,mid) >= k) {
            // We could set unit-length larger
            start = mid;
          } else {
            end = mid;
          }
        }
        if(count(L,end) >= k) {
          return end;
        }

        if(count(L,start) >=k ){
          return start;
        }
        return 0;
    }

    private int count(int[] L, int length) {
      int sum = 0;
      for(integer len : L) {
        sum += len/length;
      }
      return sum;
    }
}
