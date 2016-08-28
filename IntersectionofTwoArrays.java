/* https://leetcode.com/problems/intersection-of-two-arrays/ */
/*
  Keypoints :
    1. HashSet() add
    2. Iterator usage:
    3. Conercase return new int[0]
*/

public int[] intersection(int[] nums1, int[] nums2) {
       if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
           return new int[0];
       }

       HashSet<Integer> res = new HashSet<Integer>();

       quickSort(nums1, 0, nums1.length - 1);
       quickSort(nums2, 0, nums2.length - 1);
       int pt1 = 0;
       int pt2 = 0;

       while(pt1 < nums1.length && pt2 < nums2.length) {
           if(nums1[pt1] < nums2[pt2]) {
               pt1++;
           } else if(nums1[pt1] > nums2[pt2]) {
               pt2++;
           } else {
               res.add(nums1[pt1]);
               pt1++;
               pt2++;
           }
       }

       int [] result = new int[res.size()];

       /*
        int cnt = 0;
        for(Integer num : res) {
            result[cnt++] = num;
        }
       */

       Iterator iter = res.iterator();

       int cnt = 0;
       while(iter.hasNext()) {
           result[cnt++] = (int) iter.next();
       }


       return result;
   }

     private void quickSort(int[] A, int start, int end) {

       if(start >= end) return;

       int left = start;
       int i = start;
       int right = end;

       int pivot = A[start];

       while( i <= right) {
           if(A[i] < pivot){
               swap(A, i++, left++);
           } else if (A[i] > pivot) {
               swap(A, i, right--);
           } else {
               i++;
           }
       }

       quickSort(A, start, left -1);
       quickSort(A, right+1, end);
   }

   private void swap(int [] A, int i , int j) {
       int tmp = A[i];
       A[i] = A[j];
       A[j] = tmp;
   }
