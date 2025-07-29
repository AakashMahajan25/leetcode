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
    // TC->O(N) SC->O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode pointer = head;
        int size = 1;
        while (pointer.next != null) {
            pointer = pointer.next;
            size++;
        }
        k = k % size;
        if (k == 0) return head;
        pointer.next = head;
        ListNode newTail = head;
        for (int i = 1; i < size - k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}