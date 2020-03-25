package kuma.p04.lc0406_Queue_Reconstruction_by_Height;

import java.util.*;

public class Solution3 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> (p1[1] - p2[1]));
        List<int[]> list = new ArrayList<int[]>(people.length);
        for (int[] person : people) {
            if (list.isEmpty())
                list.add(person);
            else {
                int count = 0, index = 0;
                while (index < list.size() && count <= person[1])
                    if (list.get(index++)[0] >= person[0])
                        count++;
                if(count > person[1])
                    index--;
                list.add(index, person);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        for (int[] person : new Solution3().reconstructQueue(people))
            System.out.println(person[0] + ", " + person[1]);
    }
}
