package kuma.p03.lc0347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        MyPair[] arr = new MyPair[map.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            arr[index++] = new MyPair(entry.getKey(), entry.getValue());
        Arrays.sort(arr, ((o1,o2) -> (o2.count - o1.count)));
        List<Integer> list = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++)
            list.add(arr[i].val);
        return list;
    }

    class MyPair {
        int val;
        int count;

        public MyPair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
