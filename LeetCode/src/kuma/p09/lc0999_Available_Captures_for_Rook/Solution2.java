package kuma.p09.lc0999_Available_Captures_for_Rook;

class Solution2 {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Available
    // Captures for Rook.
    // Memory Usage: 36.8 MB, less than 13.33% of Java online submissions for
    // Available Captures for Rook.
    public int numRookCaptures(char[][] board) {
        int Rx = 0, Ry = 0;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board[i][j] == 'R') {
                    Rx = i;
                    Ry = j;
                }
        int res = 0;
        int[][] moves = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] move : moves)
            res += helper(board, Rx, Ry, move);
        return res;
    }

    private int helper(char[][] b, int x, int y, int[] move) {
        while (x >= 0 && x < 8 && y >= 0 && y < 8) {
            if (b[x][y] == 'p')
                return 1;
            if (b[x][y] == 'B')
                return 0;
            x += move[0];
            y += move[1];
        }
        return 0;
    }
}
