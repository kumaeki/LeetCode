package kuma.p02.lc0214_Shortest_Palindrome;

public class Solution2 {
    // Runtime: 174 ms, faster than 38.93% of Java online submissions for Shortest
    // Palindrome.
    // Memory Usage: 40.1 MB, less than 7.14% of Java online submissions for
    // Shortest Palindrome.
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int n = s.length();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char c = arr[0];
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == c && isPalindrome(arr, 1, j - 1)) {
                for (int i = n - 1; i > j; i--)
                    sb.append(arr[i]);
                sb.append(s);
                break;
            }
        }
        return sb.toString();
    }

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }
}
