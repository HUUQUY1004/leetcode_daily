class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int take = Math.max(dp[i-1][j-1], 0)
                        + nums1[i-1] * nums2[j-1];

                dp[i][j] = Math.max(
                        Math.max(dp[i-1][j], dp[i][j-1]),
                        take
                );
            }
        }
        return dp[n][m];

    }
}

//  Step by step explanation:
//  nums1 = [2,1,-2,5], nums2 = [3,0,-6]
//  Initialize dp array of size (5 x 5) with Integer.MIN_VALUE / 2
//  Fill dp array using nested loops:
//  i=1, j=1: take = max(dp[0][0], 0) + 2*3 = 6; dp[1][1] = max(dp[0][1], dp[1][0], take) = 6
//  i=1, j=2: take = max(dp[0][1], 0) + 2*0 = 0; dp[1][2] = max(dp[0][2], dp[1][1], take) = 6
//  i=1, j=3: take = max(dp[0][2],  0) + 2*(-6) = -12; dp[1][3] = max(dp[0][3], dp[1][2], take) = 6
//  i=1, j=4: take = max(dp[0][3], 0) + 2*0 = 0; dp[1][4] = max(dp[0][4], dp[1][3], take) = 6
//  i=2, j=1: take = max(dp[1][0], 0) + 1*3 = 3; dp[2][1] = max(dp[1][1], dp[2][0], take) = 6
//  i=2, j=2: take = max(dp[1][1], 0) + 1*0 = 6; dp[2][2] = max(dp[1][2], dp[2][1], take) = 6
//  i=2, j=3: take = max(dp[1][2], 0) + 1*(-6) = -6; dp[2][3] = max(dp[1][3], dp[2][2], take) = 6
//  i=2, j=4: take = max(dp[1][3],  0) + 1*0 = 0; dp[2][4] = max(dp[1][4], dp[2][3], take) = 6
//  i=3, j=1: take = max(dp[2][0], 0) + (-2)*3 = -6; dp[3][1] = max(dp[2][1], dp[3][0], take) = 6
//  i=3, j=2: take = max(dp[2][1], 0) + (-2)*0 = 6; dp[3][2] = max(dp[2][2], dp[3][1], take) = 6
//  i=3, j=3: take = max(dp[2][2],  0) + (-2)*(-6) = 18; dp[3][3] = max(dp[2][3], dp[3][2], take) = 18
//  i=3, j=4: take = max(dp[2][3], 0) + (-2)*0 = 0; dp[3][4] = max(dp[2][4], dp[3][3], take) = 18
//  i=4, j=1: take = max(dp[3][0], 0) + 5*3 = 15; dp[4][1] = max(dp[3][1], dp[4][0], take) = 15
//  i=4, j=2: take = max(dp[3][1], 0) + 5*0 = 15; dp[4][2] = max(dp[3][2], dp[4][1], take) = 15
//  i=4, j=3: take = max(dp[3][2],  0) + 5*(-6) = -30; dp[4][3] = max(dp[3][3], dp[4][2], take) = 18
//  i=4, j=4: take = max(dp[3][3], 0) + 5*0 = 18; dp[4][4] = max(dp[3][4], dp[4][3], take) = 18
//  The final dp array looks like this:
//    0    1    2    3    4
// 0 [0,  0,  0,  0,  0]
// 1 [0,  6,  6,  6,  6]
// 2 [0,  6,  6,  6,  6]
// 3 [0,  6,  6, 18, 18]
// 4 [0, 15, 15, 18, 18]
//  The maximum dot product is found at dp[4][4] = 18
// Time Complexity: O(n * m), where n and m are the lengths of nums1 and nums2 respectively. We fill a 2D dp array of size (n+1) x (m+1).
// Space Complexity: O(n * m) for the dp array.km