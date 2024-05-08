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
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        // Iterate through the list
        while (current.next != null) {
            // If the next node has the value to be removed, skip it
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }
        
        // Return the head of the modified list (after skipping nodes with the given value)
        return dummy.next;
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