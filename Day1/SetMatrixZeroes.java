package Day1;

class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true; //mark it for zero
                    col[j] = true; //mark it for zero
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}