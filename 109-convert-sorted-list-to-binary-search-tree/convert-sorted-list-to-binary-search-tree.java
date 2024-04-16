/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
     private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = findLength(head);
        this.head = head;

        return constructBST(0, length - 1);
    }

    private int findLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private TreeNode constructBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode leftSubtree = constructBST(start, mid - 1);

        TreeNode root = new TreeNode(this.head.val);
        root.left = leftSubtree;

        this.head = this.head.next;

        root.right = constructBST(mid + 1, end);

        return root;
    }
}