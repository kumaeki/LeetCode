package kuma.p04.lc0406_Queue_Reconstruction_by_Height;

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> (p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]));
        List<int[]> list = new ArrayList<int[]>(people.length);
        for (int[] person : people)
            list.add(person[1], person);

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        for (int[] person : new Solution().reconstructQueue(people))
            System.out.println(person[0] + ", " + person[1]);
    }
}
