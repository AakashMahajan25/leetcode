class Solution {
    public void setZeroes(int[][] matrix) {
        // Optimal Solution TC->O(MN) SC->O(1)
        int col0 = 1;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j!=0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[0][j]==0 || matrix[i][0]==0) {
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if (matrix[0][0]==0) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0==0) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        // My Solution (Better) TC->O(mXn) SC->O(m+n)
        // ArrayList<Integer> rows = new ArrayList<>();
        // ArrayList<Integer> columns = new ArrayList<>();
        // for (int i=0; i<matrix.length; i++) {
        //     for (int j=0; j<matrix[0].length; j++) {
        //         if (matrix[i][j] == 0) {
        //             rows.add(i);
        //             columns.add(j);
        //         }
        //     }
        // }
        // for (Integer row : rows) {
        //     for (int i=0; i<matrix[0].length; i++) {
        //         matrix[row][i] = 0;
        //     }
        // }
        // for (Integer column : columns) {
        //     for (int i=0; i<matrix.length; i++) {
        //         matrix[i][column] = 0;
        //     }
        // }
    }
}