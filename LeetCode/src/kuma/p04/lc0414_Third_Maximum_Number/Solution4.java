package kuma.p04.lc0414_Third_Maximum_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution4 {
    // Runtime: 4 ms, faster than 31.49% of Java online submissions for Third
    // Maximum Number.
    // Memory Usage: 39.3 MB, less than 86.96% of Java online submissions for Third
    // Maximum Number.
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.add(num)) {
                que.offer(num);
                if (que.size() > 3)
                    set.remove(que.poll());
            }
        }
        if (que.size() == 2)
            que.poll();
        return que.peek();
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution4().thirdMax(new int[] { 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(1, new Solution4().thirdMax(new int[] { 3, 1, 2 }));
    }

    @Test
    public void simple3() {
        assertEquals(-2147483648, new Solution4().thirdMax(new int[] { 1, 2, -2147483648 }));
    }
}
