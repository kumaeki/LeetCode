package kuma.p04.lc0416_Partition_Equal_Subset_Sum;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {
    @org.junit.Test
    public void simple1() {
        int[] nums = new int[] { 23, 13, 11, 7, 6, 5, 5 };
        assertEquals(true, new Solution().canPartition(nums));
    }

    @org.junit.Test
    public void simple2() {
        int[] nums = new int[] { 1, 5, 11, 5 };
        assertEquals(true, new Solution().canPartition(nums));
    }

    @org.junit.Test
    public void simple3() {
        int[] nums = new int[] { 1, 2, 3, 5 };
        assertEquals(false, new Solution().canPartition(nums));
    }

    @org.junit.Test
    public void simple4() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        assertEquals(true, new Solution().canPartition(nums));
    }

    @org.junit.Test
    public void simple5() {
        int[] nums = new int[] { 1, 2, 5 };
        assertEquals(false, new Solution().canPartition(nums));
    }

    @org.junit.Test
    public void long1() {
        int[] nums = new int[] { 28, 63, 95, 30, 39, 16, 36, 44, 37, 100, 61, 73, 32, 71, 100, 2, 37, 60, 23, 71, 53,
                70, 69, 82, 97, 43, 16, 33, 29, 5, 97, 32, 29, 78, 93, 59, 37, 88, 89, 79, 75, 9, 74, 32, 81, 12, 34,
                13, 16, 15, 16, 40, 90, 70, 17, 78, 54, 81, 18, 92, 75, 74, 59, 18, 66, 62, 55, 19, 2, 67, 30, 25, 64,
                84, 25, 76, 98, 59, 74, 87, 5, 93, 97, 68, 20, 58, 55, 73, 74, 97, 49, 71, 42, 26, 8, 87, 99, 1, 16,
                79 };
        assertEquals(true, new Solution().canPartition(nums));
    }
}
