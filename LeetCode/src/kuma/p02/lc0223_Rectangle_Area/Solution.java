package kuma.p02.lc0223_Rectangle_Area;

public class Solution {
    // Runtime: 2 ms, faster than 100.00% of Java online submissions for Rectangle
    // Area.
    // Memory Usage: 38.7 MB, less than 8.00% of Java online submissions for
    // Rectangle Area.
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (D - B) * (C - A) + (H - F) * (G - E);

        int x1 = Math.max(A, E), x2 = Math.min(C, G);
        int y1 = Math.max(B, F), y2 = Math.min(H, D);
        int repeat = (y2 > y1 && x2 > x1) ? (y2 - y1) * (x2 - x1) : 0;
        return area - repeat;
    }
}
