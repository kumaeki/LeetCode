package kuma.p00.lc0037_Sudoku_Solver;

import java.util.*;

public class Solution2 {
    // Runtime: 2 ms, faster than 98.80% of Java online submissions for Sudoku
    // Solver.
    // Memory Usage: 37.1 MB, less than 21.05% of Java online submissions for Sudoku
    // Solver.
    int[][] rows, columns, boxs;

    public void solveSudoku(char[][] board) {
        rows = new int[9][9];
        columns = new int[9][9];
        boxs = new int[9][9];

        char c;
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            for (int j = 0; j < 9; j++) {
                c = row[j];
                if (c == '.')
                    continue;
                rows[i]['9' - c] = 1;
                columns[j]['9' - c] = 1;
                boxs[3 * (i / 3) + j / 3]['9' - c] = 1;
            }
        }

        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        if (j == 9)
            return helper(board, i + 1, 0);
        int[] row = rows[i], col = columns[j], box = boxs[3 * (i / 3) + j / 3];

        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                int index = '9' - c;
                if (row[index] == 0 && col[index] == 0 && box[index] == 0) {
                    board[i][j] = c;
                    row[index] = 1;
                    col[index] = 1;
                    box[index] = 1;
                    if (helper(board, i, j + 1)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        row[index] = 0;
                        col[index] = 0;
                        box[index] = 0;
                    }
                }
            }
            return false;
        }
        return helper(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        new Solution2().solveSudoku(board);
        printBoard(board);
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row)
                System.out.print(c + ",");
            System.out.println("");
        }
        System.out.println("------------------------");
    }
}
