package kuma.p08.lc0835_Image_Overlap;

class Solution2 {
    // Runtime: 2 ms, faster than 100.00% of Java online submissions for Image
    // Overlap.
    // Memory Usage: 39.2 MB, less than 100.00% of Java online submissions for Image
    // Overlap.
    public int largestOverlap(int[][] A, int[][] B) {
        int len = A.length, res = 0;
        int[] m1 = toArr(A, len), m2 = toArr(B, len);
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++) {
                res = Math.max(res, getCount(m1, m2, i, j, len));
                res = Math.max(res, getCount(m2, m1, i, j, len));
            }
        return res;
    }

    private int[] toArr(int[][] matrix, int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int[] row = matrix[i];
            int r = 0;
            for (int j = 0; j < len; j++)
                r |= (row[j] << j);
            arr[i] = r;
        }
        return arr;
    }

    private int getCount(int[] m1, int[] m2, int dx, int dy, int len) {
        int res = 0;
        for (int i = 0; i < len - dx; i++) {
            int num1 = m1[i];
            int num2 = m2[i + dx] >> dy;
            res += Integer.bitCount(num1 & num2);
        }
        return res;
    }
}