package kuma.p09.lc0900_RLE_Iterator;

import java.util.*;

public class RLEIterator {

    // Runtime: 6 ms, faster than 40.37% of Java online submissions for RLE
    // Iterator.
    // Memory Usage: 40 MB, less than 53.33% of Java online submissions for RLE
    // Iterator.
    Queue<int[]> que;

    public RLEIterator(int[] A) {
        que = new LinkedList<int[]>();
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] == 0)
                continue;
            que.add(new int[] { A[i], A[i + 1] });
        }
    }

    public int next(int n) {
        while (n > 0 && !que.isEmpty()) {
            if (que.peek()[0] > n) {
                que.peek()[0] -= n;
                return que.peek()[1];
            } else if (que.peek()[0] < n) {
                n -= que.poll()[0];
            } else {
                return que.poll()[1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RLEIterator ite = new RLEIterator(new int[] { 3, 8, 0, 9, 2, 5 });
        System.out.println(ite.next(2));
        System.out.println(ite.next(1));
        System.out.println(ite.next(1));
        System.out.println(ite.next(2));
    }
}
