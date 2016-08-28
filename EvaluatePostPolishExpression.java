/* http://www.lintcode.com/en/problem/evaluate-reverse-polish-notation/# */


public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;

        for(int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];
            int op1 = 0;
            int op2 = 0;

            switch (curr) {
                case "+" :
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2+op1);
                    break;

                case "-" :
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2-op1);

                    break;

                case "*" :
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2*op1);

                    break;

                case "/" :
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;

                default :
                    int currInt = Integer.valueOf(curr);
                    stack.push(currInt);
            }

        }
        return (stack.peek());

    }
}
