/* https://leetcode.com/problems/mini-parser/ */

/*
This problem is very similiar to the Decoding String
Main idea is to call dfs when encountering '[' and return when encounter
']'
*/


public NestedInteger deserialize(String s) {
       NestedInteger res = new NestedInteger();
       if(s == null || s.length() == 0) return res;
       dfs(s, 0, res);
       List<NestedInteger> tmpList = res.getList();
       return tmpList.get(0);
   }

   // This will return the index that has been processed by next level
   private int dfs(String s, int start, NestedInteger parent) {
       if(start > s.length()) return s.length();

       for(int i = start; i < s.length();) {
           // If its ']' means need to get to the previous layer
           if(s.charAt(i) == ']') {
               return i + 1;
           }

           // Find the integer part and add it to
           if(s.charAt(i) == ',') {
               i++;
           } else if(s.charAt(i) != '[') {
               boolean negative = false;
               if(s.charAt(i) == '-') {
                   negative = true;
                   i++;
               }
               int tmp = i;
               while(tmp < s.length() && Character.isDigit(s.charAt(tmp))) {
                   tmp++;
               }
               //System.out.println("i--> " + i +"tmp---> " + tmp);
               int intPart = Integer.parseInt(s.substring(i,tmp));
               parent.add(new NestedInteger(negative ? -intPart : intPart));
               i = tmp;
           } else {
                NestedInteger curr = new NestedInteger();
                int nextI = dfs(s, i+1, curr);
                parent.add(curr);
                i = nextI;
           }
       }

       return s.length();
   }



/* 网友的 Stack Solution */

   public NestedInteger deserialize(String s) {
      String[] tokens = s.split(",");
      Stack<NestedInteger> stack = new Stack();
      NestedInteger root = new NestedInteger();
      stack.push(root);

      for (String token: tokens) {
          int start = 0;
          int end = token.length();

          while (token.charAt(start) == '[') {
              stack.push(new NestedInteger());
              start++;
          }

          NestedInteger topMost = stack.peek();

          while (token.charAt(end - 1) == ']') {
              NestedInteger prevList = stack.pop();
              stack.peek().add(prevList);
              end--;
          }

          if (start < end) {
              NestedInteger curInteger = new NestedInteger(Integer.parseInt(token.substring(start, end)));
              topMost.add(curInteger);
          }
      }

      return root.getList().get(0);
  }
