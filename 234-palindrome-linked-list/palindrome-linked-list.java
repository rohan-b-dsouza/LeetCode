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
    public boolean isPalindrome(ListNode head) {
        // Stack for popping elements in LL in reverse order
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        // Push all elements in stack
        while (temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        // Compare LL's elements with popped elements
        while (temp != null) {
            // Return false if its not a palindrome
            if (temp.val != st.pop()) {
                return false;
            }
            temp = temp.next;
        }
        // Return true if its a palindrome
        return true;

    }
}