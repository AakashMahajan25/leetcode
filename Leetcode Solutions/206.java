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
    // Recursive Approach
    // TC->O(N) SC->O(N) due to Call Stack
    private ListNode changeOrder(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        return changeOrder(prev, temp);
    }
    public ListNode reverseList(ListNode head) {
        return changeOrder(null, head);


        // Iterative Approach (Optimal Approach)
        // TC->O(N) SC->O(1)
        // ListNode prev = null;
        // ListNode curr = head;
        // ListNode temp = null;
        // while (curr != null) {
        //     temp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = temp;
        // }
        // return prev;


        // Brute Force Approach
        // TC->O(N) SC->O(N)
        // Stack<Integer> stack = new Stack<>();
        // if (head == null) {
        //     return head;
        // }
        // ListNode temp = head;
        // while (temp != null) {
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }
        // temp = head;
        // while (temp != null) {
        //     temp.val = stack.pop();
        //     temp = temp.next;
        // }
        // return head;
    }
}