package kuma.p00.lc0037_Sudoku_Solver;

import java.util.*;

public class Solution {
    // Runtime: 12 ms, faster than 51.03% of Java online submissions for Sudoku
    // Solver.
    // Memory Usage: 39.3 MB, less than 10.53% of Java online submissions for Sudoku
    // Solver.
    Set<Character>[] rows, columns, boxs;

    @SuppressWarnings("unchecked")
    public void solveSudoku(char[][] board) {
        rows = new HashSet[9];
        columns = new HashSet[9];
        boxs = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>(9);
            columns[i] = new HashSet<Character>(9);
            boxs[i] = new HashSet<Character>(9);
        }
        char c;
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            for (int j = 0; j < 9; j++) {
                c = row[j];
                if (c == '.')
                    continue;
                rows[i].add(c);
                columns[j].add(c);
                boxs[3 * (i / 3) + j / 3].add(c);
            }
        }

        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        if (j == 9)
            return helper(board, i + 1, 0);
        Set<Character> row = rows[i], col = columns[j], box = boxs[3 * (i / 3) + j / 3];

        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                if (!row.contains(c) && !col.contains(c) && !box.contains(c)) {
                    board[i][j] = c;
                    row.add(c);
                    col.add(c);
                    box.add(c);
                    if (helper(board, i, j + 1)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                        row.remove(c);
                        col.remove(c);
                        box.remove(c);
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
        new Solution().solveSudoku(board);
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
