package kuma.p08.lc0870_Advantage_Shuffle;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

public class Solution2 {
    // Runtime: 17 ms, faster than 99.73% of Java online submissions for Advantage
    // Shuffle.
    // Memory Usage: 40.6 MB, less than 100.00% of Java online submissions for
    // Advantage Shuffle.
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        int[] index = new int[n], res = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;
        Arrays.sort(A);
        sortQuick(B, index, 0, n - 1);
        if (A[0] > B[index[n - 1]] && A[n - 1] < B[index[0]])
            return A;

        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int a : A)
            list.addLast(a);
        int i = 0;
        while (!list.isEmpty()) {
            while (n > 0 && list.getFirst() <= B[index[i]]) {
                list.addLast(list.removeFirst());
                n--;
            }
            res[index[i++]] = list.removeFirst();
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
        new Solution2().sortQuick(new int[] { 13, 25, 32, 11 }, index, 0, 3);
        Arrays.stream(index).forEach(x -> System.out.println(x));
    }

    @Test
    public void simple1() {
        assertArrayEquals(new int[] { 24, 32, 8, 12 },
                new Solution2().advantageCount(new int[] { 12, 24, 8, 32 }, new int[] { 13, 25, 32, 11 }));
    }

    @Test
    public void simple2() {
        assertArrayEquals(new int[] { 2, 11, 7, 15 },
                new Solution2().advantageCount(new int[] { 2, 7, 11, 15 }, new int[] { 1, 10, 4, 11 }));
    }

}
