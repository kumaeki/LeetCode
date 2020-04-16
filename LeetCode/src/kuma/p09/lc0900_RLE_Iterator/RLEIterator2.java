package kuma.p09.lc0900_RLE_Iterator;

public class RLEIterator2 {

    // Runtime: 5 ms, faster than 96.31% of Java online submissions for RLE
    // Iterator.
    // Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for RLE
    // Iterator.
    int[] A;
    int index, len;

    public RLEIterator2(int[] A) {
        this.A = A;
        this.len = A.length;
        this.index = 0;
    }

    public int next(int n) {
        while (n > 0 && index < len) {
            if (A[index] > n) {
                A[index] -= n;
                return A[index + 1];
            } else if (A[index] < n) {
                n -= A[index];
                index += 2;
            } else {
                index += 2;
                return A[index - 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RLEIterator2 ite = new RLEIterator2(new int[] { 3, 8, 0, 9, 2, 5 });
        System.out.println(ite.next(2));
        System.out.println(ite.next(1));
        System.out.println(ite.next(1));
        System.out.println(ite.next(2));
    }
}
