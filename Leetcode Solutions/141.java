/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // TC->O(N) SC->O(1) Tortoise and Hare Algorithm
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            fastPointer = fastPointer.next;

            if (slowPointer == fastPointer) {
                return true;
            }
        }

        return false;


        // TC->O(N) SC->O(N)
        // HashMap<ListNode, Boolean> map = new HashMap<>();
        // ListNode temp = head;
        // while (temp != null) {
        //     if (map.getOrDefault(temp, false) == true) {
        //         return true;
        //     } else {
        //         map.put(temp, true);
        //         temp = temp.next;
        //     }
        // }
        // return false;
    }
}