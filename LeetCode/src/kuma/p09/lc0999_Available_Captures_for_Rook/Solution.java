package kuma.p09.lc0999_Available_Captures_for_Rook;

class Solution {
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
        int left = Ry, right = Ry, up = Rx, down = Rx;
        while (--left >= 0) {
            if (board[Rx][left] == 'B')
                break;
            else if (board[Rx][left] == 'p') {
                res++;
                break;
            }
        }
        while (++right < 8) {
            if (board[Rx][right] == 'B')
                break;
            else if (board[Rx][right] == 'p') {
                res++;
                break;
            }
        }
        while (--up >= 0) {
            if (board[up][Ry] == 'B')
                break;
            else if (board[up][Ry] == 'p') {
                res++;
                break;
            }
        }
        while (++down < 8) {
            if (board[down][Ry] == 'B')
                break;
            else if (board[down][Ry] == 'p') {
                res++;
                break;
            }
        }
        return res;
    }
}
