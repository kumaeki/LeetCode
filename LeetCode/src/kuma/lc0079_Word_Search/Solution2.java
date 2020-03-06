package kuma.lc0079_Word_Search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution2 {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (helper(board, isVisited, word, i, j))
                    return true;

        return false;
    }

    private boolean helper(char[][] board, boolean[][] isVisited, String word, int x, int y) {
        if (word.length() == 0)
            return false;
        if (word.length() == 1) {
            return isContained(board, isVisited, word.charAt(0), x, y);
        } else {
            if (!isContained(board, isVisited, word.charAt(0), x, y))
                return false;
            else {
                isVisited[x][y] = true;
                boolean res = helper(board, isVisited, word.substring(1), x, y + 1)
                        || helper(board, isVisited, word.substring(1), x, y - 1)
                        || helper(board, isVisited, word.substring(1), x + 1, y)
                        || helper(board, isVisited, word.substring(1), x - 1, y);
                isVisited[x][y] = false;
                return res;
            }
        }
    }

    private boolean isContained(char[][] board, boolean[][] isVisited, char c, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length && !isVisited[x][y] && board[x][y] == c;
    }

    @Test
    public void simple1() {
        boolean expected = true;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        boolean actual = new Solution2().exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        boolean expected = true;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SEE";
        boolean actual = new Solution2().exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        boolean expected = false;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCB";
        boolean actual = new Solution2().exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        boolean expected = false;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "";
        boolean actual = new Solution2().exist(board, word);
        assertEquals(expected, actual);
    }
}
