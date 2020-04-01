package kuma.p04.lc0414_Third_Maximum_Number;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution2 {
    // Runtime: 102 ms, faster than 5.19% of Java online submissions for Third
    // Maximum Number.
    // Memory Usage: 40.4 MB, less than 8.70% of Java online submissions for Third
    // Maximum Number.
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums)
            set.add(num);
        List<Integer> list = new ArrayList<Integer>(set);
        int len = list.size();
        if (len < 3)
            return list.size() == 1 ? list.get(0) : list.get(0) > list.get(1) ? list.get(0) : list.get(1);
        else
            sort(list, 0, len - 1, len - 3);
        return list.get(len - 3);
    }

    private void sort(List<Integer> list, int left, int right, int target) {
        int val = list.get(left), i = left + 1, j = right;
        while (true) {
            while (i <= j && list.get(i) < val)
                i++;
            while (i <= j && list.get(j) > val)
                j--;
            if (i >= j)
                break;
            Collections.swap(list, i, j);
        }
        Collections.swap(list, left, j);
        if (j < target)
            sort(list, j + 1, right, target);
        else if (j > target)
            sort(list, left, j - 1, target);
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution2().thirdMax(new int[] { 1, 1 }));
    }

    @Test
    public void simple2() {
        assertEquals(1, new Solution2().thirdMax(new int[] { 3, 1, 2 }));
    }
}
