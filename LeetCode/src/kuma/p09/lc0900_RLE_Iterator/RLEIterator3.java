package kuma.p09.lc0900_RLE_Iterator;

public class RLEIterator3 {

    // Runtime: 5 ms, faster than 96.31% of Java online submissions for RLE
    // Iterator.
    // Memory Usage: 39.8 MB, less than 53.33% of Java online submissions for RLE
    // Iterator.
    int[] A;
    int index, len;

    public RLEIterator3(int[] A) {
        this.A = A;
        this.len = A.length;
        this.index = 0;
    }

    public int next(int n) {
        while (index < len && n > A[index]) {
            n -= A[index];
            index += 2;
        }
        if (index >= len)
            return -1;
        A[index] -= n;
        return A[index + 1];
    }

    public static void main(String[] args) {
        RLEIterator3 ite = new RLEIterator3(new int[] { 3, 8, 0, 9, 2, 5 });
        System.out.println(ite.next(2));
        System.out.println(ite.next(1));
        System.out.println(ite.next(1));
        System.out.println(ite.next(2));
    }
}
