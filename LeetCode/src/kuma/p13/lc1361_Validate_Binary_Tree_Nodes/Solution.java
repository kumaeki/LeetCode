package kuma.p13.lc1361_Validate_Binary_Tree_Nodes;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] arr = new int[n];
        for (int c : leftChild) {
            if (c == 0)
                return false;
            if (c == -1)
                continue;
            if (arr[c] == 1)
                return false;
            arr[c] = 1;
        }
        for (int c : rightChild) {
            if (c == 0)
                return false;
            if (c == -1)
                continue;
            if (arr[c] == 1)
                return false;
            arr[c] = 1;
        }
        for (int i = 1; i < n; i++)
            if (arr[i] == 0)
                return false;
        return true;
    }
}
