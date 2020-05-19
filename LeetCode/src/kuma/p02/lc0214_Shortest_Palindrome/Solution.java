package kuma.p02.lc0214_Shortest_Palindrome;

public class Solution {
    // Runtime: 172 ms, faster than 39.40% of Java online submissions for Shortest Palindrome.
    // Memory Usage: 39.7 MB, less than 7.14% of Java online submissions for Shortest Palindrome.
    public String shortestPalindrome(String s) {
        int n = s.length(), j = n - 1;
        char[] arr = s.toCharArray();
        while (j > 0 && !isPalindrome(arr, j))
            j--;
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(j + 1)).reverse().append(s);
        return sb.toString();
    }

    private boolean isPalindrome(char[] arr, int right) {
        int left = 0;
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
