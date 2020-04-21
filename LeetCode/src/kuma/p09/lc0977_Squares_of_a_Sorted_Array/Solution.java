package kuma.p09.lc0977_Squares_of_a_Sorted_Array;

public class Solution {
    // Runtime: 3 ms, faster than 15.66% of Java online submissions for Squares of a
    // Sorted Array.
    // Memory Usage: 41.2 MB, less than 95.73% of Java online submissions for
    // Squares of a Sorted Array.
    public int[] sortedSquares(int[] A) {
        int[] arr = new int[10001];
        for (int a : A)
            arr[Math.abs(a)]++;

        int[] res = new int[A.length];
        int index = 0;
        for (int i = 0; i < 10001; i++)
            while (arr[i]-- > 0)
                res[index++] = i * i;

        return res;
    }
}
