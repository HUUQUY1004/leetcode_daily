class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        int currentLevel = 0;

        while (!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                resultLevel = currentLevel;
            }
        }

        return resultLevel;
    }
}
// Code run 
// Input: [1,7,0,7,-8,null,null]
// Level 1 sum = 1
// Level 2 sum = 7 + 0 = 7
// Level 3 sum = 7 + (-8) = -1
// Output: 2
// Time Complexity: O(N), where N is the number of nodes in the binary tree. We visit each node exactly once.
// Space Complexity: O(M), where M is the maximum number of nodes at any level in the binary tree (the width of the tree). This space is used by the queue to store nodes at the current level.
// The maximum width of a binary tree can be as large as N/2 in the case of a complete binary tree.