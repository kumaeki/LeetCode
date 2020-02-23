package kuma.lc0011_Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int max = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int low = height[right];
            if (height[left] < height[right])
                low = height[left++];
            else
                right--;
            max = Math.max(max, width * low);
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++)
            for (int j = i + 1; j < len; j++)
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
        return max;
    }
}
