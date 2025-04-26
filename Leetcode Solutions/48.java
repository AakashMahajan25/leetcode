import java.util.Arrays;
class Solution {
    public void rotate(int[][] matrix) {
        // Optimal Solution TC->O(n^2) SC->O(1)
        int temp = -1;
        int n = matrix.length;
        // Transposing the Matrix
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {    // It will be a square matrix only
                if (i==j) {
                    continue;
                } else {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        // Inverting the Rows
        for (int i=0; i<n; i++) {
           int left = 0;
           int right = n-1;
           while (left < right) {
            temp = matrix[i][left];
            matrix[i][left] = matrix[i][right];
            matrix[i][right] = temp;
            left++;
            right--;
           }
        }
    }
}