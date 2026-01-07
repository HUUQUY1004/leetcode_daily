class Solution {
    public int maxProduct(TreeNode root) {
        long MOD = 1_000_000_007;
        long totalSum = getTotalSum(root);
        long[] maxProduct = new long[1];
        getMaxProduct(root, totalSum, maxProduct);
        return (int)(maxProduct[0] % MOD);
    }
    
    private long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    private long getMaxProduct(TreeNode root, long totalSum, long[] maxProduct) {
        if (root == null) return 0;
        long leftSum = getMaxProduct(root.left, totalSum, maxProduct);
        long rightSum = getMaxProduct(root.right, totalSum, maxProduct);
        long currentSum = root.val + leftSum + rightSum;
        maxProduct[0] = Math.max(maxProduct[0], (totalSum - currentSum) * currentSum);
        return currentSum;
    }
}
// [1,2,3,4,5,6]
// Step by step explanation:
// totalSum = sum of all nodes in the tree = 21
// For each subtree, calculate its sum and the product of splitting the tree at that subtree
// Subtree rooted at 4: sum = 4, product = 4 * (21 - 4) = 68
// Subtree rooted at 5: sum = 5, product = 5 * (21 - 5) = 80
// Subtree rooted at 6: sum = 6, product = 6 * (    21 - 6) = 90
// Subtree rooted at 2: sum = 2 + 4 + 5 = 11, product = 11 * (21 - 11) = 110
// Subtree rooted at 3: sum = 3 + 6 = 9, product = 9 * (21 - 9) = 108
// Subtree rooted at 1: sum = 21, product = 21 * (21 - 21) = 0
// The maximum product is 110 from splitting at subtree rooted at 2
// Time Complexity: O(N), where N is the number of nodes in the binary tree. We visit each node exactly twice (once for total sum and once for max product).
// Space Complexity: O(H), where H is the height of the binary tree. This space is used by the recursion stack.