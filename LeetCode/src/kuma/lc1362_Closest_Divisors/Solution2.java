package kuma.lc1362_Closest_Divisors;

class Solution2 {
    public int[] closestDivisors(int num) {
        int[] arr1 = helper(num + 1);
        int[] arr2 = helper(num + 2);
        return arr1[1] - arr1[0] < arr2[1] - arr2[0] ? arr1 : arr2;
    }

    public int[] helper(int num) {
        int can = (int) Math.sqrt(num);
        while (can > 1) {
            if (num % can == 0)
                return new int[] { can, num / can };
            else
                can--;
        }
        return new int[] { 1, num };
    }

}
