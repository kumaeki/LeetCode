package kuma.p07.lc0746_Min_Cost_Climbing_Stairs;

public class Solution2 {
    // Runtime: 1 ms, faster than 90.25% of Java online submissions for Min Cost
    // Climbing Stairs.
    // Memory Usage: 39.9 MB, less than 28.57% of Java online submissions for Min
    // Cost Climbing Stairs.
    public int minCostClimbingStairs(int[] cost) {
        int pre2 = 0, pre1 = 0, cur = 0;
        for (int i = 2; i <= cost.length; i++) {
            cur = Math.min(pre1 + cost[i - 1], pre2 + cost[i - 2]);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
