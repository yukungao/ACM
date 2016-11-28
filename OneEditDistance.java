/* https://leetcode.com/problems/one-edit-distance/ */
/*
注意要问以下几个问题:
1. If not exact one, return false; else return true;
2. 典型的追赶型pointer, implementation的题

*/

public boolean isOneEditDistance(String s, String t) {

    if((s == null && t == null) || (s.length() == 0 && t.length() == 0)) {
        return false;
    }

    if(s == null && t != null) {
        if(t.length() > 1) {
            return false;
        } else {
            return true;
        }
    }

    if(t == null && s != null) {
        if(s.length() > 1) {
            return false;
        } else {
            return true;
        }
    }

    int s_size = s.length();
    int t_size = t.length();

    if(Math.abs(s_size - t_size) > 1) {
        return false;
    }

    int p1 = 0;
    int p2 = 0;
    int count = 0;

    // Find the first different
    while(p1 < s_size && p2 < t_size) {
        if(s.charAt(p1) != t.charAt(p2)) {
            break;
        }
        p1++;
        p2++;
    }

    // The only differnce could be at most 1
    if(p1 == s_size || p2 == t_size){
        if(s_size == t_size) {
            return false;
        } else {
            return true;
        }
    }


    // Finish one edit
    if(s_size == t_size) {
        p1++;
        p2++;
    } else {
        if(s_size < t_size) {
            p2++;
        } else {
            p1++;
        }

    }

    count++;

    // After this, no changes are expected.
    while(p1 < s_size && p2 < t_size) {
            if(s.charAt(p1) != t.charAt(p2)) {
                 count++;
                 break;
            }
            p1++;
            p2++;
    }

    return count == 1;
}
