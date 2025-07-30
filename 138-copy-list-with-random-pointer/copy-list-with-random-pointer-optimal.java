// Optimal

/*Definition of singly linked list:
class Node {
    int val;
    Node next;
    Node random;

    Node() {
        val = 0;
        next = null;
        random = null;
    }

    Node(int val) {
        this.val = val;
        next = null;
        random = null;
    }

    Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
 */

class Solution {
    public Node copyRandomList(Node head) {
        // If list is empty return null
        if (head == null) return head;
        Node temp = head;
        // Step 1 : Place each new copy of original node between the original list's two nodes
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        temp = head;
        // Step 2 : Link the copied node's to their corresponding random nodes
        while (temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }
        temp = head;
        Node dummyNode = new Node(-1);
        Node dummy = dummyNode;
        // Restore the original list's node's next connections and also simultaneously link the copied node's to their corresponding next nodes
        while (temp != null) {
            dummy.next = temp.next;
            dummy = dummy.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        // Return the copy list
        return dummyNode.next;
    }
}

// T.C => O(3 * n) = O(n)
// S.C => O(1)
