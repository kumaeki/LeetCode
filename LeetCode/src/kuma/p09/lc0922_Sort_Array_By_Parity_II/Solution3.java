package kuma.p09.lc0922_Sort_Array_By_Parity_II;

class Solution3 {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array
    // By Parity II.
    // Memory Usage: 41 MB, less than 96.30% of Java online submissions for Sort
    // Array By Parity II.
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        for (int odd = 1; odd < A.length; odd += 2) {
            if ((A[odd] & 1) == 0) {
                while ((A[even] & 1) == 0)
                    even += 2;
                int temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }
        return A;
    }
}
