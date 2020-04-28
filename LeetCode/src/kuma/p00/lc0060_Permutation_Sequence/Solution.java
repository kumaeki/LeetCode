package kuma.p00.lc0060_Permutation_Sequence;

public class Solution {
    // Runtime: 1 ms, faster than 97.73% of Java online submissions for Permutation
    // Sequence.
    // Memory Usage: 36.9 MB, less than 20.83% of Java online submissions for
    // Permutation Sequence.
    public String getPermutation(int n, int k) {
        int[] facs = new int[n], nums = new int[n];
        facs[0] = 1;
        for (int i = 1; i < n; i++)
            facs[i] = facs[i - 1] * (i + 1);
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        k--;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            int index = k / facs[n - 2 - i];
            for (int j = 0; j < n; j++) {
                if (nums[j] == 0)
                    continue;

                if (index == 0) {
                    sb.append(nums[j]);
                    nums[j] = 0;
                    break;
                } else
                    index--;
            }
            k %= facs[n - 2 - i];
        }
        for (int num : nums)
            if (num != 0) {
                sb.append(num);
                break;
            }

        return sb.toString();
    }
}
