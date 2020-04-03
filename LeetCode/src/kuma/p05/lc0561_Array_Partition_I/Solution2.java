package kuma.p05.lc0561_Array_Partition_I;

public class Solution2 {
    // Runtime: 4 ms, faster than 99.89% of Java online submissions for Array
    // Partition I.
    // Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Array
    // Partition I.

    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20001];
        for (int num : nums)
            arr[num + 10000]++;

        int count = 0, res = 0;
        for (int i = 0; i < 20001; i++) {
            if (arr[i] > 0) {
                if ((count & 1) == 1) {
                    res += (i - 10000) * (arr[i] / 2);
                } else {
                    res += (i - 10000) * ((arr[i] + 1) / 2);
                }
                count += arr[i];
            }
        }
        return res;
    }
}
