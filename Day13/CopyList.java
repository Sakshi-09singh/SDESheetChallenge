package Day13;

public class CopyList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public Node copyRandomList(Node head) {
        
        if (head == null) {
            return null;
        }

        Node temp = head;

        // Step 1: Insert copy nodes in between
        while (temp != null) {

            Node copy = new Node(temp.val);

            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }

        // Step 2: Assign random pointers
        temp = head;

        while (temp != null) {

            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }

            temp = temp.next.next;
        }

        // Step 3: Separate the lists
        temp = head;

        Node dummy = new Node(0);
        Node copyTail = dummy;

        while (temp != null) {

            Node copy = temp.next;

            temp.next = copy.next;

            copyTail.next = copy;
            copyTail = copy;

            temp = temp.next;
        }

        return dummy.next;
    }
}
