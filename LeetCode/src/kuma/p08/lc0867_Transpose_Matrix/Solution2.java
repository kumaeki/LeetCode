package kuma.p08.lc0867_Transpose_Matrix;

public class Solution2 {
    //  if A.length == A[0].length
    public int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length, k = Integer.MAX_VALUE >> 16;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int val = A[i][j];
                if (val > k)
                    val = val >> 16;
                A[j][i] = A[j][i] << 16 | val;
            }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = A[i][j] & k;

        return A;
    }
}
