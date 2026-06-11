/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionLL {
    class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { 
                val = x;
                next = null;
             }
        }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            // if a reaches end, move to headB
            a = (a == null) ? headB : a.next;

            // if b reaches end, move to headA
            b = (b == null) ? headA : b.next;
        }

        return a; // intersection node or null
    }
}