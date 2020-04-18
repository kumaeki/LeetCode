package kuma.p09.lc0922_Sort_Array_By_Parity_II;

class Solution2 {
    // Runtime: 2 ms, faster than 99.54% of Java online submissions for Sort Array
    // By Parity II.
    // Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for Sort
    // Array By Parity II.
    public int[] sortArrayByParityII(int[] A) {
        int even = 0, odd = 1, n = A.length;
        while (even < n && odd < n) {
            while (even < n && (A[even] & 1) == 0)
                even += 2;
            while (odd < n && (A[odd] & 1) == 1)
                odd += 2;
            if (odd < n && even < n) {
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }
        return A;
    }
}
