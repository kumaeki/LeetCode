package kuma.lc1260_Shift_2D_Grid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int x = k / n;
        int y = k - (x * n);
        List<List<Integer>> resList = new ArrayList<List<Integer>>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                int prex = i - x;
                int prey = j - y;
                if (prey < 0) {
                    prey = n + prey;
                    prex--;
                }
                if (prex < 0)
                    prex = m + prex;

                list.add(grid[prex][prey]);
            }
            resList.add(list);
        }
        return resList;
    }

    private List<List<Integer>> getList(int[][] grid) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            resList.add(list);
        }
        return resList;
    }

    @Test
    public void testSimple1() {
        int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;
        List<List<Integer>> expected = getList(new int[][] { { 9, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } });
        List<List<Integer>> actual = new Solution().shiftGrid(grid, k);
        assertEquals(expected, actual);
    }

}
