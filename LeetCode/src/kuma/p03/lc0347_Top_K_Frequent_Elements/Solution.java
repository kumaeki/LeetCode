package kuma.p03.lc0347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        MyPair[] arr = new MyPair[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            arr[index++] = new MyPair(entry.getKey(), entry.getValue());

        sort(arr, k, 0, map.size() - 1);

        List<Integer> list = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++)
            list.add(arr[i].val);
        return list;
    }

    private void sort(MyPair[] arr, int k, int left, int right) {
        if (left >= right)
            return;

        swap(arr, (left + right) / 2, right);
        int index = left;
        int countR = arr[right].count;
        for (int i = left; i < right; i++) {
            if (arr[i].count >= countR)
                swap(arr, i, index++);
        }
        swap(arr, index, right);
        if (index + 1 < k)
            sort(arr, k, index + 1, right);
        else if (index + 1 > k)
            sort(arr, k, left, index - 1);

    }

    private void swap(MyPair[] arr, int i, int j) {
        MyPair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
