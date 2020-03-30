package kuma.p01.lc0189_Rotate_Array;

public class Solution2 {
    // Runtime: 0 ms, faster than 100.00%
    // Memory Usage: 39.9 MB, less than 5.77%
    public void rotate(int[] nums, int k) {
        int len = nums.length, backup, next, cur, count = 0;
        for (int i = 0; count < len; i++) {
            cur = i;
            backup = nums[cur];
            do {
                next = (cur + k) % len;
                int temp = nums[next];
                nums[next] = backup;
                backup = temp;
                cur = next;
                count++;
            } while (next != i);
        }
    }
}
