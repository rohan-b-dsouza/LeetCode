// Brute

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
        // HashMap which maps the original node to the copied node
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        // Store {original node, copied node} pair
        while (temp != null) {
            Node newNode = new Node (temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        // Link the newly created copied nodes to their corresponding next and random nodes using the map 
        temp = head;
        while (temp != null) {
            Node copiedNode = map.get(temp);
            copiedNode.next = map.get(temp.next);
            copiedNode.random = map.get(temp.random);
            temp = temp.next; 
        }
        // Return the head of the newly copied list
        return map.get(head);
    }
}

// T.C => O(n) + O(n) = O(2 * n) = O(n)
// S.C => O(n) + O(n) = O(2 * n) = O(n) --------{It's imp to note that the extra map is used to solve the problem however the new LL creation is a requirement of the problem itself so the new LL is not used to solve qn but to return the ans}
