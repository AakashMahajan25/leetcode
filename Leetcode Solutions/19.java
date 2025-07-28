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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i=0; i<n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }



    // TC->O(2N) SC->O(1)
    // private ListNode removeNodeFromFront(ListNode head, int n) {
    //     if (n==1) return head.next;
    //     ListNode prev = null;
    //     ListNode elem = null;
    //     ListNode temp = head;
    //     int index = 1;
    //     while (temp != null) {
    //         if (index == n-1) {
    //             prev = temp;
    //             elem = temp.next;
    //             prev.next = elem.next;
    //             return head;
    //         }
    //         temp = temp.next;
    //         index++;
    //     }
    //     return head;
    // }
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     int size = 1;
    //     ListNode temp = head;
    //     while (temp.next != null) {
    //         temp = temp.next;
    //         size++;
    //     }
    //     if (size==1) return null;
    //     head = removeNodeFromFront(head, size - n + 1);
    //     return head;
    // }
}