package kuma.p03.lc0347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<MyPair> que = new PriorityQueue<MyPair>(new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                return o2.count - o1.count;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            que.add(new MyPair(entry.getKey(), entry.getValue()));
        List<Integer> list = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++)
            list.add(que.poll().val);
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
