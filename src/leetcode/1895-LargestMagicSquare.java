class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowPrefix = new int[m][n + 1];
        int[][] colPrefix = new int[n][m + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
                colPrefix[j][i + 1] = colPrefix[j][i] + grid[i][j];
            }
        }

        for (int size = Math.min(m, n); size >= 1; size--) {
            for (int i = 0; i <= m - size; i++) {
                for (int j = 0; j <= n - size; j++) {
                    if (isMagicSquare(grid, rowPrefix, colPrefix, i, j, size)) {
                        return size;
                    }
                }
            }
        }

        return 1;
    }

    private boolean isMagicSquare(int[][] grid, int[][] rowPrefix, int[][] colPrefix, int row, int col, int size) {
        int targetSum = rowPrefix[row][col + size] - rowPrefix[row][col];

        for (int i = 0; i < size; i++) {
            if (rowPrefix[row + i][col + size] - rowPrefix[row + i][col] != targetSum) {
                return false;
            }
            if (colPrefix[col + i][row + size] - colPrefix[col + i][row] != targetSum) {
                return false;
            }
        }

        int diagSum1 = 0, diagSum2 = 0;
        for (int i = 0; i < size; i++) {
            diagSum1 += grid[row + i][col + i];
            diagSum2 += grid[row + i][col + size - 1 - i];
        }

        return diagSum1 == targetSum && diagSum2 == targetSum;
    }
}