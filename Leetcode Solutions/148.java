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
    // TC->O(nlogn) SC->O(1)
    ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; 
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        return dummyNode.next;
    }


    ListNode findMiddle(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
    
        return slow;
    }

    ListNode sortLL(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
    
        ListNode right = middle.next;
        middle.next = null;
        ListNode left = head;
    
        left = sortLL(left);
        right = sortLL(right);
    
        return mergeTwoSortedLinkedLists(left, right);
    }
    public ListNode sortList(ListNode head) {
        head = sortLL(head);
        return head;
    }


    // TC->O(nlogn) SC->O(N)
    // public ListNode sortList(ListNode head) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     ListNode temp = head;
    //     while (temp != null) {
    //         list.add(temp.val);
    //         temp = temp.next;
    //     }
    //     Collections.sort(list, Collections.reverseOrder());
    //     temp = head;
    //     while (temp != null) {
    //         temp.val = list.remove(list.size() -1);
    //         temp = temp.next;
    //     }
    // return head;
    // }
}