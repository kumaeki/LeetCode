package kuma.lc1263_Minimum_Moves_to_Move_a_Box_to_Their_Target_Location;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.Test;

public class Solution {

    int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    char[][] grid;
    int m, n;

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int[] target = null, box = null, storeKeeper = null;
        for (int i = 0; i < m; i++) {
            if (target != null && box != null && storeKeeper != null)
                break;
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == 'S')
                    storeKeeper = new int[] { i, j };
                else if (c == 'T')
                    target = new int[] { i, j };
                else if (c == 'B')
                    box = new int[] { i, j };
            }
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Queue<Integer> que = new LinkedList<Integer>();
        int res = Integer.MAX_VALUE;
        int start = encode(storeKeeper[0], storeKeeper[1], box[0], box[1]);
        map.put(start, 0);
        que.offer(start);
        while (!que.isEmpty()) {
            int cur = que.poll();
            int dis = map.get(cur);
            if (dis >= res)
                continue;

            int[] dcur = decode(cur);
            // if the box is at the position of the target
            if (dcur[2] == target[0] && dcur[3] == target[1]) {
                res = Math.min(res, dis);
                continue;
            }

            // storeKeeper
            int[] s = new int[] { dcur[0], dcur[1] };
            // box
            int[] b = new int[] { dcur[2], dcur[3] };
            for (int[] move : moves) {
                int newsx = s[0] + move[0];
                int newsy = s[1] + move[1];
                if (!isAvailable(newsx, newsy))
                    continue;
                int next;
                // if the storeKeeper meet the box, then the box move in the same direction
                if (newsx == b[0] && newsy == b[1]) {
                    int newbx = b[0] + move[0];
                    int newby = b[1] + move[1];
                    if (!isAvailable(newbx, newby))
                        continue;
                    next = encode(newsx, newsy, newbx, newby);
                    // the next state is already exist, and have less distance
                    if (map.containsKey(next) && map.get(next) <= dis + 1)
                        continue;
                    map.put(next, dis + 1);
                    que.offer(next);

                    // if the storeKeeper do not meet the box, the position of the box do not change
                } else {
                    next = encode(newsx, newsy, b[0], b[1]);
                    // the next state is already exist, and have less distance
                    if (map.containsKey(next) && map.get(next) <= dis)
                        continue;
                    map.put(next, dis);
                    que.offer(next);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private boolean isAvailable(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }

    private int encode(int staffx, int staffy, int boxx, int boxy) {
        return (staffx << 24) | (staffy << 16) | (boxx << 8) | boxy;
    }

    private int[] decode(int state) {
        int[] res = new int[4];
        res[0] = state >>> 24;
        res[1] = (state >>> 16) & 0xff;
        res[2] = (state >>> 8) & 0xff;
        res[3] = state & 0xff;
        return res;
    }

    @Test
    public void testSimple1() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#' }, { '#', 'T', '#', '#', '#', '#' },
                { '#', '.', '.', 'B', '.', '#' }, { '#', '.', '#', '#', '.', '#' }, { '#', '.', '.', '.', 'S', '#' },
                { '#', '#', '#', '#', '#', '#' } };
        int expected = 3;
        int actual = new Solution().minPushBox(testGrid);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSimple2() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#' }, { '#', 'T', '#', '#', '#', '#' },
                { '#', '.', '.', 'B', '.', '#' }, { '#', '#', '#', '#', '.', '#' }, { '#', '.', '.', '.', 'S', '#' },
                { '#', '#', '#', '#', '#', '#' } };
        int expected = -1;
        int actual = new Solution().minPushBox(testGrid);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple3() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#' }, { '#', 'T', '.', '.', '#', '#' },
                { '#', '.', '#', 'B', '.', '#' }, { '#', '.', '.', '.', '.', '#' }, { '#', '.', '.', '.', 'S', '#' },
                { '#', '#', '#', '#', '#', '#' } };
        int expected = 5;
        int actual = new Solution().minPushBox(testGrid);
        assertEquals(expected, actual);
    }

    @Test
    public void testSimple4() {
        char[][] testGrid = new char[][] { { '#', '#', '#', '#', '#', '#', '#' }, { '#', 'S', '#', '.', 'B', 'T', '#' },
                { '#', '#', '#', '#', '#', '#', '#' } };
        int expected = -1;
        int actual = new Solution().minPushBox(testGrid);
        assertEquals(expected, actual);
    }
}
