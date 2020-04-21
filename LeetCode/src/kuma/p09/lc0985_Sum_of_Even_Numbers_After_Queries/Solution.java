package kuma.p09.lc0985_Sum_of_Even_Numbers_After_Queries;

public class Solution {
    // Runtime: 3 ms, faster than 100.00% of Java online submissions for Sum of Even
    // Numbers After Queries.
    // Memory Usage: 48.4 MB, less than 100.00% of Java online submissions for Sum
    // of Even Numbers After Queries.
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int n = queries.length, sum = 0;
        int[] res = new int[n];

        for (int a : A)
            if ((a & 1) == 0)
                sum += a;

        for (int i = 0; i < n; i++) {
            int[] arr = queries[i];
            int index = arr[1], val = arr[0];
            if (A[index] % 2 == 0)
                sum -= A[index];
            A[index] += val;
            if (A[index] % 2 == 0)
                sum += A[index];
            res[i] = sum;
        }

        return res;
    }
}
