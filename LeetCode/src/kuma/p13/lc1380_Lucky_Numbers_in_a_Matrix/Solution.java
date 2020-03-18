package kuma.p13.lc1380_Lucky_Numbers_in_a_Matrix;

import java.util.*;

/**
 * 
 * 1380. Lucky Numbers in a Matrix
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 * 
 * 
 * Example 1:
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * 
 * Example 2:
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * 
 * Example 3:
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 * 
 * 
 * Constraints:
 * * m == mat.length
 * * n == mat[i].length
 * * 1 <= n, m <= 50
 * * 1 <= matrix[i][j] <= 10^5.
 * * All elements in the matrix are distinct.
 * 
 * @param matrix
 * @return
 */


public class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] arrMax = new int[n], arrMin = new int[m];
        Arrays.fill(arrMin, Integer.MAX_VALUE);
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                arrMin[i] = Math.min(arrMin[i], matrix[i][j]);
                arrMax[j] = Math.max(arrMax[j], matrix[i][j]);
            }
        
        Set<Integer> set = new HashSet<Integer>(m);
        for(int num : arrMin)
            set.add(num);
        
        List<Integer> list = new ArrayList<Integer>(n);
        for(int num : arrMax)
            if(set.contains(num))
                list.add(num);
            
        return list;
    }
}
