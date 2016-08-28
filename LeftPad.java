/* http://www.lintcode.com/en/problem/left-pad/# */
/*
 题目大概就是补全左边的String.
 1. StringBuilder sb;
 2. sb.length()
 3. sb.insert(offset,char);
*/
static public String leftPad(String originalStr, int size) {
    // Write your code here
    return leftPad(originalStr, size, ' ');
}

/**
 * @param originalStr the string we want to append to
 * @param size the target length of the string
 * @param padChar the character to pad to the left side of the string
 * @return a string
 */
static public String leftPad(String originalStr, int size, char padChar) {
    // Write your code here
    StringBuilder sb = new StringBuilder(originalStr);
    while(sb.length() < size) {
        sb.insert(0,padChar);
    }
    return sb.toString();
}
