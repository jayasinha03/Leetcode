/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       // Copy the value of the next node into the current node
        node.val = node.next.val;
        // Delete the next node by updating the current node's next pointer
        node.next = node.next.next;
    }

    // Helper function to print the linked list
    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null"); 
    }
}