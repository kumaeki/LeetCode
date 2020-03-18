package kuma.p00.lc0079_Word_Search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution {

    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        this.board = board;
        this.word = word;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (helper(0, i, j))
                    return true;

        return false;
    }

    private boolean helper(int index, int x, int y) {
        if (index == word.length() || x < 0 || x == board.length || y < 0 || y == board[0].length
                || board[x][y] != word.charAt(index))
            return false;

        if (index == word.length() - 1) {
            return true;
        } else {
            index++;
            char temp = board[x][y];
            board[x][y] = ' ';
            boolean res = helper(index, x, y + 1) || helper(index, x, y - 1) || helper(index, x + 1, y)
                    || helper(index, x - 1, y);
            board[x][y] = temp;
            return res;
        }
    }

    @Test
    public void simple1() {
        boolean expected = true;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";
        boolean actual = new Solution().exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void simple2() {
        boolean expected = true;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SEE";
        boolean actual = new Solution().exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void simple3() {
        boolean expected = false;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCB";
        boolean actual = new Solution().exist(board, word);
        assertEquals(expected, actual);
    }

    @Test
    public void simple4() {
        boolean expected = false;
        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "";
        boolean actual = new Solution().exist(board, word);
        assertEquals(expected, actual);
    }
}
