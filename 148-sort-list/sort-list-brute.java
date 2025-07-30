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
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        // Store all elements of LL into a list
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        // Sort the list
        list.sort(null);
        temp = head;
        int cnt = 0;
        // Overwrite LL with these sorted node values
        while (temp != null) {
            temp.val = list.get(cnt++);
            temp = temp.next;
        }
        return head;
    }
}

// T.C => O(n + (n * log(n)) + O(n)) = O(n * log(n))
// S.C => O(n) for the extra list used
