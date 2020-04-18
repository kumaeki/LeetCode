package kuma.p09.lc0922_Sort_Array_By_Parity_II;

class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Sort Array
    // By Parity II.
    // Memory Usage: 45 MB, less than 7.41% of Java online submissions for Sort
    // Array By Parity II.
    public int[] sortArrayByParityII(int[] A) {
        int[] arr = new int[1001];
        for (int a : A)
            arr[a]++;

        int[] B = new int[A.length];
        int even = 0, odd = 1;
        for (int i = 0; i < 1001; i++) {
            while (arr[i]-- > 0) {
                if ((i & 1) == 1) {
                    B[odd] = i;
                    odd += 2;
                } else {
                    B[even] = i;
                    even += 2;
                }
            }
        }
        return B;
    }
}
