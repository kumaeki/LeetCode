package kuma.lc0096_Unique_Binary_Search_Trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// to slow
class Solution2 {
        public int numTrees(int n) {
            int res = 0;
            for (int i = 1; i <= n; i++)
                res += helper(i, 1, n);
            return res;
        }

        private int helper(int root, int leftmin, int rightmax) {
            if (root == leftmin && root == rightmax)
                return 1;
            int resleft = 0;
            int resright = 0;
            if (root != leftmin) {
                for (int i = root - 1; i >= leftmin; i--)
                    resleft += helper(i, leftmin, root - 1);
            }

            if (root != rightmax) {
                for (int i = root + 1; i <= rightmax; i++)
                    resright += helper(i, root + 1, rightmax);
            }

            return (resleft == 0 ? 1 : resleft) * (resright == 0 ? 1 : resright);

        }

    @Test
    public void simple1() {
        int expected = 1;
        int actual = new Solution2().numTrees(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void simple2() {
        int expected = 2;
        int actual = new Solution2().numTrees(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void simple3() {
        int expected = 5;
        int actual = new Solution2().numTrees(3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void simple4() {
        int expected = 14;
        int actual = new Solution2().numTrees(4);
        assertEquals(expected, actual);
    }
    @Test
    public void simple5() {
        int expected = 42;
        int actual = new Solution2().numTrees(5);
        assertEquals(expected, actual);
    }
}