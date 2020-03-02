package kuma.lc0049_Group_Anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < str.length(); i++)
                arr[str.charAt(i) - 'a']++;
            String key = new String(arr);
            List<String> val = map.getOrDefault(key, new ArrayList<String>());
            val.add(str);
            map.put(key, val);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
