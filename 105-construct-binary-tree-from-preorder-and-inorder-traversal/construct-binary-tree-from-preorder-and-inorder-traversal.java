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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length - 1,
                               inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd,
                                     int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // The first element in the preorder traversal is the root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the index of the root in the inorder traversal
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        
        // Calculate the size of the left subtree
        int leftSubtreeSize = rootIndex - inStart;
        
        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
                                    inorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd,
                                     inorder, rootIndex + 1, inEnd);
        
        return root;
    }
}