class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        long sum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = matrix[i][j];
                if (value < 0) {
                    negativeCount++;
                    value = -value;
                }
                sum += value;
                minAbsValue = Math.min(minAbsValue, value);
            }
        }

        if (negativeCount % 2 == 1) {
            sum -= 2L * minAbsValue;
        }

        return sum;
    }
}

// space Complexity: O(1), as we use only a constant amount of extra space regardless of the input size.
// Time Complexity: O(n * m), where n is the number of rows and m is
// Run
//  [[1,2,3],[-1,-2,-3],[1,2,3]]
// sum = 18
//  negativeCount = 3
// minAbsValue = 1
// Output: 16 (sum - 2 * minAbsValue = 18 - 2 * 1 = 16)