class Solution {
    // Optimal Solution TC->O(log(m*n)) SC->O(1)
    int maxIndex(int[][] mat, int m, int mid) {
        int maxIndex = 0;
        for (int i=0; i<m; i++) {
            if (mat[i][mid] > mat[maxIndex][mid]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            int maxInd = maxIndex(mat, m, mid);
            int left = mid-1>=0 ? mat[maxInd][mid-1] : -1;
            int right = mid+1<n ? mat[maxInd][mid+1] : -1;
            if (mat[maxInd][mid] > left && mat[maxInd][mid] > right) {
                return new int[] {maxInd, mid};
            } else if (mat[maxInd][mid] < left) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return new int[] {-1, -1};





        // My Approach (Greedy) TC->O(m*n) SC->O(1) 
        // int m = mat.length;
        // int n = mat[0].length;
        // int i = 0;
        // int j = 0;
        // int nextI = 0;
        // int nextJ = 0;
        // int maxValue = mat[0][0];
        // while (true) {
        //     if (i>0 && mat[i-1][j] > maxValue) {
        //         maxValue = mat[i-1][j];
        //         nextI = i-1;
        //         nextJ = j; 
        //     }
        //     if (i<m-1 && mat[i+1][j] > maxValue) {
        //         maxValue = mat[i+1][j];
        //         nextI = i+1;
        //         nextJ = j;
        //     }
        //     if (j>0 && mat[i][j-1] > maxValue) {
        //         maxValue = mat[i][j-1];
        //         nextI = i;
        //         nextJ = j-1;
        //     }
        //     if (j<n-1 && mat[i][j+1] > maxValue) {
        //         maxValue = mat[i][j+1];
        //         nextI = i;
        //         nextJ = j+1;
        //     }
        //     if (i==nextI && j==nextJ) {
        //         return new int[] {i, j};
        //     }
        //     i = nextI;
        //     j = nextJ;
        // }
    }
}