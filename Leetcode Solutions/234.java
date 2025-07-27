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
    private ListNode reverseLinkedlist(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        // Optimal Approach TC->O(N) SC->O(1)
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode middle = slowPointer;
        slowPointer = reverseLinkedlist(slowPointer);
        fastPointer = head;
        while (slowPointer != null) {
            if (slowPointer.val != fastPointer.val) {
                reverseLinkedlist(middle);
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        } 
        reverseLinkedlist(middle);
        return true;
        


        // Brute Force Approach -> Use a Stack
        // TC->O(2N) SC->O(N)
    }
}