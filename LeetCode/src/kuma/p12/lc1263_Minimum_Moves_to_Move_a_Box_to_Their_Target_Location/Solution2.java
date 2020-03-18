package kuma.p12.lc1263_Minimum_Moves_to_Move_a_Box_to_Their_Target_Location;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Solution2 {

    int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    char[][] g;
    int m, n;

    public int minPushBox(char[][] grid) {

        g = grid;
        m = grid.length;
        n = grid[0].length;
        int[] storekeeper = null, box = null, target = null;

        // search the position of storeKeeper,box,target
        for (int i = 0; i < m; i++) {
            if (storekeeper != null && box != null && target != null)
                break;
            for (int j = 0; j < n; j++) {
                char c = g[i][j];
                if (c == 'B')
                    box = new int[] { i, j };
                else if (c == 'S')
                    storekeeper = new int[] { i, j };
                else if (c == 'T')
                    target = new int[] { i, j };
                // set these position as floor
                if (c != '#' && c != '.')
                    g[i][j] = '.';
            }
        }

        Queue<int[]> que = new LinkedList<int[]>();
        boolean[][][] isVisited = new boolean[m][n][4];
        que.offer(new int[] { box[0], box[1], storekeeper[0], storekeeper[1] });
        int res = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len > 0) {
                int[] status = que.poll();
                g[status[0]][status[1]] = '#';
                for (int i = 0; i < 4; i++) {
                    int[] move = moves[i];
                    // the new position of box
                    int newbx = status[0] + move[0];
                    int newby = status[1] + move[1];
                    // the new position of storeKeeper
                    int newsx = status[0] - move[0];
                    int newsy = status[1] - move[1];
                    if (isAvailable(newsx, newsy) && isAvailable(newbx, newby) && !isVisited[newsx][newsy][i]
                            && isAccessible(newsx, newsy, status[2], status[3])) {
                        // if the target is reached
                        if (newbx == target[0] && newby == target[1])
                            return res + 1;
                        else {
                            que.offer(new int[] { newbx, newby, status[0], status[1] });
                            isVisited[newsx][newsy][i] = true;
                        }
                    }
                }
                g[status[0]][status[1]] = '.';
                len--;
            }
            res++;
        }

        return -1;
    }

    // check if the position is available(in the bound and is floor)
    private boolean isAvailable(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && g[x][y] != '#' && g[x][y] != '#';
    }

    // check if accessible form the current position of storeKeeper to the new
    // position
    private boolean isAccessible(int newx, int newy, int curx, int cury) {
        if (newx == curx && newy == cury)
            return true;

        Queue<int[]> que = new LinkedList<int[]>();
        boolean[][] isVisited = new boolean[m][n];
        que.offer(new int[] { curx, cury });
        while (!que.isEmpty()) {
            int[] status = que.poll();
            for (int[] move : moves) {
                int nextx = status[0] + move[0];
                int nexty = status[1] + move[1];
                if (isAvailable(nextx, nexty) && !isVisited[nextx][nexty]) {
                    if (newx == nextx && newy == nexty)
                        return true;
                    isVisited[nextx][nexty] = true;
                    que.offer(new int[] { nextx, nexty });
                }
            }
        }
        return false;
    }

    @Test
    public void testSimple1() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#' }, { '#', 'T', '#', '#', '#', '#' },
                { '#', '.', '.', 'B', '.', '#' }, { '#', '.', '#', '#', '.', '#' }, { '#', '.', '.', '.', 'S', '#' },
                { '#', '#', '#', '#', '#', '#' } };
        int expected = 3;
        int actual = new Solution2().minPushBox(testGrid);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple2() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#' }, { '#', 'T', '#', '#', '#', '#' },
                { '#', '.', '.', 'B', '.', '#' }, { '#', '#', '#', '#', '.', '#' }, { '#', '.', '.', '.', 'S', '#' },
                { '#', '#', '#', '#', '#', '#' } };
        int expected = -1;
        int actual = new Solution2().minPushBox(testGrid);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#' }, { '#', 'T', '.', '.', '#', '#' },
                { '#', '.', '#', 'B', '.', '#' }, { '#', '.', '.', '.', '.', '#' }, { '#', '.', '.', '.', 'S', '#' },
                { '#', '#', '#', '#', '#', '#' } };
        int expected = 5;
        int actual = new Solution2().minPushBox(testGrid);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#', '#' }, { '#', 'S', '#', '.', 'B', 'T', '#' },
                { '#', '#', '#', '#', '#', '#', '#' } };
        int expected = -1;
        int actual = new Solution2().minPushBox(testGrid);
        assertEquals(expected, actual);
    }
}
