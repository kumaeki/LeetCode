package kuma.p07.lc0782_Transform_to_Chessboard;

class Solution {
    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Transform
    // to Chessboard.
    // Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for
    // Transform to Chessboard.
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((board[0][0] ^ board[0][j] ^ board[i][0] ^ board[i][j]) == 1)
                    return -1;

        int countRow = 0, countColumn = 0;
        int sumRow = 0, sumColumn = 0;
        for (int i = 0; i < n; i++) {
            sumColumn += board[0][i];
            sumRow += board[i][0];
            if (board[0][i] == i % 2)
                countColumn++;
            if (board[i][0] == i % 2)
                countRow++;
        }

        if ((sumColumn != n / 2 && sumColumn != (n + 1) / 2) || (sumRow != n / 2 && sumRow != (n + 1) / 2))
            return -1;

        if (n % 2 == 0) {
            if (countColumn > n / 2)
                countColumn = n - countColumn;
            if (countRow > n / 2)
                countRow = n - countRow;
        } else {
            if (countColumn % 2 == 1)
                countColumn = n - countColumn;
            if (countRow % 2 == 1)
                countRow = n - countRow;
        }
        return (countRow + countColumn) / 2;
    }
}
