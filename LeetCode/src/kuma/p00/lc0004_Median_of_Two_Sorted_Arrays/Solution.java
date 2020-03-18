package kuma.p00.lc0004_Median_of_Two_Sorted_Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int len = m + n, half = (len + 1) / 2;
        int left = 0, right = m;
        int i = 0, j = 0;
        while (left <= right) {
            i = (left + right) / 2;
            j = half - i;
            if (i < right && nums1[i] < nums2[j - 1])
                left = i + 1;
            else if (i > left && nums2[j] < nums1[i - 1])
                right = i - 1;
            else
                break;
        }
        int maxleft;
        if (i == 0)
            maxleft = nums2[j - 1];
        else if (j == 0)
            maxleft = nums1[i - 1];
        else
            maxleft = Math.max(nums1[i - 1], nums2[j - 1]);
        if (len % 2 == 1)
            return maxleft;

        int minright;
        if (i == m)
            minright = nums2[j];
        else if (j == n)
            minright = nums1[i];
        else
            minright = Math.min(nums1[i], nums2[j]);

        return (maxleft + minright) / 2.0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int[] arr = new int[len];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j])
                arr[k++] = nums1[i++];
            else
                arr[k++] = nums2[j++];
            if (k > len / 2)
                break;
        }
        if (k <= len / 2) {
            while (i < m)
                arr[k++] = nums1[i++];
            while (j < n)
                arr[k++] = nums2[j++];
        }

        if (len % 2 == 0)
            return (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
        else
            return arr[len / 2];
    }

    @Test
    public void TestSimple1() {
        int[] nums1 = new int[] { 1, 3 };
        int[] nums2 = new int[] { 2 };
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);
        double expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void TestSimple2() {
        int[] nums1 = new int[] { 1, 3 };
        int[] nums2 = new int[] { 2, 4 };
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);
        double expected = 2.5;
        assertEquals(expected, actual);
    }

    @Test
    public void TestSimple3() {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3, 4 };
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);
        double expected = 2.5;
        assertEquals(expected, actual);
    }

    @Test
    public void TestSimple4() {
        int[] nums1 = new int[] { 1 };
        int[] nums2 = new int[] { 2 };
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);
        double expected = 1.5;
        assertEquals(expected, actual);
    }
}
