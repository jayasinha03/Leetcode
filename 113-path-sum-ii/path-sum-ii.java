/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, 0, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, int currentSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null)
            return;

        currentSum += node.val;
        currentPath.add(node.val);

        if (node.left == null && node.right == null) { // Leaf node
            if (currentSum == targetSum)
                result.add(new ArrayList<>(currentPath));
        } else {
            dfs(node.left, targetSum, currentSum, currentPath, result);
            dfs(node.right, targetSum, currentSum, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1); // Backtrack
    }
}