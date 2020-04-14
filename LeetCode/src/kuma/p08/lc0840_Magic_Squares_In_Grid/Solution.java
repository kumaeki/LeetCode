package kuma.p08.lc0840_Magic_Squares_In_Grid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Magic
    // Squares In Grid.
    // Memory Usage: 37.7 MB, less than 10.00% of Java online submissions for Magic
    // Squares In Grid.
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i <= grid.length - 3; i++)
            for (int j = 0; j <= grid[0].length - 3; j++)
                res += isMagic(grid, i, j);
        return res;
    }

    private int isMagic(int[][] grid, int i, int j) {
        if (grid[i + 1][j + 1] != 5)
            return 0;

        int[] arr = new int[10];
        for (int k = i; k < i + 3; k++)
            for (int m = j; m < j + 3; m++)
                if (grid[k][m] < 1 || grid[k][m] > 9 || arr[grid[k][m]] == 1)
                    return 0;
                else
                    arr[grid[k][m]]++;

        int[] r0 = grid[i], r1 = grid[i + 1], r2 = grid[i + 2];
        return (15 == r0[j] + r0[j + 1] + r0[j + 2] && 15 == r1[j] + r1[j + 1] + r1[j + 2]
                && 15 == r2[j] + r2[j + 1] + r2[j + 2] && 15 == r0[j] + r1[j] + r2[j]
                && 15 == r0[j + 1] + r1[j + 1] + r2[j + 1] && 15 == r0[j + 2] + r1[j + 2] + r2[j + 2]
                && 15 == r0[j] + r1[j + 1] + r2[j + 2] && 15 == r0[j + 2] + r1[j + 1] + r2[j]) ? 1 : 0;
    }

    @Test
    public void simple1() {
        assertEquals(1, new Solution().numMagicSquaresInside(new int[][] { { 3, 10, 2, 3, 4 }, { 4, 5, 6, 8, 1 },
                { 8, 8, 1, 6, 8 }, { 1, 3, 5, 7, 1 }, { 9, 4, 9, 2, 9 } }));
    }
}
