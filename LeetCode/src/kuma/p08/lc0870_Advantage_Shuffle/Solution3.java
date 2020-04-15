package kuma.p08.lc0870_Advantage_Shuffle;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.junit.Test;

public class Solution3 {
    // Runtime: 27 ms, faster than 95.63% of Java online submissions for Advantage
    // Shuffle.
    // Memory Usage: 44.7 MB, less than 16.67% of Java online submissions for
    // Advantage Shuffle.
    public int[] advantageCount(int[] A, int[] B) {

        int[] newB = B.clone();
        Arrays.sort(newB);
        Arrays.sort(A);

        Map<Integer, Queue<Integer>> map = new HashMap<Integer, Queue<Integer>>();
        for (int b : B)
            map.put(b, new LinkedList<Integer>());
        Queue<Integer> que = new LinkedList<Integer>();

        int i = 0;
        for (int a : A)
            if (a > newB[i]) {
                map.get(newB[i++]).add(a);
            } else
                que.offer(a);

        int l = A.length;
        int[] res = new int[l];
        for (int j = 0; j < l; j++) {
            Queue<Integer> q = map.get(B[i]);
            if (!q.isEmpty())
                res[j] = q.poll();
            else
                res[j] = que.poll();
        }

        return res;
    }

    private void sortQuick(int[] arr, int[] index, int left, int right) {
        if (left >= right)
            return;
        int temp = arr[index[left]];
        int i = left + 1;
        for (int j = left + 1; j <= right; j++) {
            if (arr[index[j]] <= temp)
                swap(index, i++, j);
        }
        swap(index, left, i - 1);
        sortQuick(arr, index, left, i - 2);
        sortQuick(arr, index, i, right);
    }

    private void swap(int[] index, int i, int j) {
        int temp = index[j];
        index[j] = index[i];
        index[i] = temp;
    }

    public static void main(String[] args) {
        int[] index = new int[] { 0, 1, 2, 3 };
        new Solution3().sortQuick(new int[] { 13, 25, 32, 11 }, index, 0, 3);
        Arrays.stream(index).forEach(x -> System.out.println(x));
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 24, 32, 8, 12 },
                new Solution3().advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 }));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new int[] { 2, 11, 7, 15 },
                new Solution3().advantageCount(new int[] { 2, 7, 11, 15 }, new int[] { 1, 10, 4, 11 }));
    }

}
