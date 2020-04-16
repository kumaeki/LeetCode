package kuma.p09.lc0905_Sort_Array_By_Parity;

public class Solution {
    // Runtime: 1 ms, faster than 99.58% of Java online submissions for Sort Array
    // By Parity.
    // Memory Usage: 40.5 MB, less than 90.97% of Java online submissions for Sort
    // Array By Parity.
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (i < j && ((A[i] & 1) == 0))
                i++;
            while (i < j && ((A[j] & 1) == 1))
                j--;
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
