package kuma.p02.lc0289_Game_of_Life;

public class Solution {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of
    // Life.
    // Memory Usage: 37.9 MB, less than 7.69% of Java online submissions for Game of
    // Life.
    final static int OUT = -1;
    final static int DEAD = 0;
    final static int DEAD_LIVE = 10;
    final static int LIVE = 1;
    final static int LIVE_DEAD = 11;
    final static int[][] NEIGHBORS = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 },
            { 1, 0 }, { 1, 1 } };
    int m, n;

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                helper(board, i, j);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == DEAD_LIVE)
                    board[i][j] = LIVE;
                else if (board[i][j] == LIVE_DEAD)
                    board[i][j] = DEAD;
    }

    private void helper(int[][] board, int i, int j) {
        int countLive = 0, cur = board[i][j];
        for (int[] nei : NEIGHBORS) {
            int res = isLive(board, i + nei[0], j + nei[1]);
            if (res == LIVE || res == LIVE_DEAD)
                countLive++;
        }
        if (cur == 1 && (countLive < 2 || countLive > 3))
            cur = LIVE_DEAD;
        else if (cur == 0 && countLive == 3)
            cur = DEAD_LIVE;
        board[i][j] = cur;
    }

    private int isLive(int[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return OUT;
        else
            return board[i][j];
    }

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } });
    }
}
