package kuma.p02.lc0239_Sliding_Window_Maximum;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            pq.add(nums[i]);
            if (pq.size() > k)
                pq.remove(nums[i - k]);
            if (pq.size() == k)
                res[i - k + 1] = pq.peek();
        }
        return res;
    }
}
