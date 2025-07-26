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
    // TC->O(N) SC->O(N)
    public ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            fastPointer = fastPointer.next;
        }
        return slowPointer;
    }


    // TC->O(2N) SC->O(N)
    // public ListNode middleNode(ListNode head) {
    //     ListNode temp = head;
    //     int size = 1;
    //     int pointer = 1;
    //     while (temp.next != null) {
    //         size++;
    //         temp = temp.next;
    //     }
    //     temp = head;
    //     int middle = (size/2)+1;
    //     while (temp.next != null || size==2) {
    //         if (pointer==middle) {
    //             return temp;
    //         }
    //         pointer++;
    //         temp = temp.next;
    //     }
    //     return head;
    // }
}