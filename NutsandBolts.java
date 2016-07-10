/* http://www.lintcode.com/en/problem/nuts-bolts-problem/ */

/*
Given a set of n nuts of different sizes and n bolts of different sizes.
There is a one-one mapping between nuts and bolts.
Comparison of a nut to another nut or a bolt to another bolt is not allowed.
It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
We will give you a compare function to compare nut with bolt.
*/

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts == null || bolts == null || nuts.length == 0 || bolts.length == 0) return;

        quickSort(nuts, bolts, 0, nuts.length-1, compare);
    }

    public void quickSort(String[] nuts, String[] bolts, int start, int end, NBComparator compare) {
        if(start >= end) return;
        int pivot = sortBolts(nuts[start], bolts, start, end, compare);

        sortNuts(nuts,bolts[pivot],start,end,compare);

        quickSort(nuts, bolts, start, pivot -1, compare);
        quickSort(nuts, bolts, pivot+1, end, compare);
    }


    private int sortNuts(String[] nuts, String bolt, int start, int end, NBComparator compare) {
        if(start >= end) return end;
        int left = start;
        int right = end;
        int i = start;

        while(i <= right) {
            if(compare.cmp(nuts[i],bolt) == 1) {
                swap(nuts, i++, left++);
            } else if(compare.cmp(nuts[i],bolt) == -1) {
                swap(nuts, i, right--);
            } else {
                i++;
            }
        }

        return left;
    }

    public int sortBolts(String nut, String[] bolts, int start, int end, NBComparator compare) {
        if(start >= end) return end;
        int left = start;
        int right = end;
        int i = start;

        while( i <= right) {
            if(compare.cmp(nut,bolts[i]) == -1) {
                swap(bolts, i++, left++);
            } else if(compare.cmp(nut,bolts[i]) == 1) {
                swap(bolts, i, right--);
            } else {
                i++;
            }
        }
        return left;
    }

    public void swap(String[] A, int i , int j) {
        String tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
};
