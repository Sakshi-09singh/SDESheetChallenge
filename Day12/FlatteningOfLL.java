public class FlatteningOfLL {
    class ListNode {
        int val;
        ListNode next;
        ListNode child;

        ListNode() {
            val = 0;
            next = null;
            child = null;
        }

        ListNode(int data1) {
            val = data1;
            next = null;
            child = null;
        }

        ListNode(int data1, ListNode next1, ListNode next2) {
            val = data1;
            next = next1;
            child = next2;
        }
   }
    public ListNode flattenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = flattenLinkedList(head.next);

        return merge(head, head.next);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }

            temp = temp.child;
            temp.next = null;
        }

        if (a != null) {
            temp.child = a;
        } else {
            temp.child = b;
        }

        return dummy.child;
    }
}
