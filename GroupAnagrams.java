/* https://leetcode.com/submissions/detail/79982385/ */

/*

The following one, will fail the testcase:
Input ["", ""]
Output[[""],[""]]
Expect[["",""]]

原因可能是因为“”作为key比较vague?
*/

public List<List<String>> groupAnagrams(String[] strs) {
    // HashTable to
    // sortedkey -> List<>;
    List<List<String>> res = new ArrayList<>();
    if(strs == null || strs.length == 0) return res;
    Map<String, List<String>> map = new HashMap<>();

    for(String str : strs) {
        // Sort str;
        char [] ary = str.toCharArray();
        Arrays.sort(ary);
        String ana = ary.toString();

        if(!map.containsKey(ana)){
            map.put(ana, new ArrayList<String>());
        }

        List<String> ref = map.get(ana);
        ref.add(str);
        map.put(ana, ref);
    }

    for(String key : map.keySet()) {
        res.add(map.get(key));
    }

    return res;
}


/*
我屮艸芔茻,我发现了一个了不起的方式. 其实这个题的本质是为anagram 做个 key.. 那可以用
encoding的方式来做啊.... char+itscount...比方说: abaacb = a3b2c1...
我曹,这个就能唯一确定一个anagram了，根本不用sort的一刚！！！
*/
