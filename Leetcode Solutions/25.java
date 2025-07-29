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
    class NodePair {
        ListNode head;
        ListNode tail;

        NodePair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    private NodePair reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && k>0) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            k--;
        }
        return new NodePair(prev, head);
    }
    private ListNode checkAndReverse(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (true) {
            ListNode check = current.next;
            int count = 0;

            while (count < k && check != null) {
                check = check.next;
                count++;
            }

            if (count < k) break;

            ListNode groupHead = current.next;
            NodePair reversed = reverse(groupHead, k);

            current.next = reversed.head;
            groupHead.next = check;
            current = groupHead;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        head = checkAndReverse(head, k);
        return head;
    }
}