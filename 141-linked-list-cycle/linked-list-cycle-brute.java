// Brute

/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        // Hashset to store visited nodes
        HashSet<ListNode> st = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            // If visited node appears, cycle exists return true
            if (st.contains(temp)) {
                return true;
            }
            // Store current node to the HashSet
            st.add(temp);
            temp = temp.next;
        }
        // If no cycle detected, return false
        return false;
    }
}

// T.C => O(n)
// S.C => O(n) for the extra hashset used
