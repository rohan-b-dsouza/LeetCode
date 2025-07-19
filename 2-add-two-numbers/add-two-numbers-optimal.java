// Optimal

/*Definition for singly Linked List
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(-1); // dummy node to make building ans linked list simpler
    ListNode tail = dummyHead; // assign tail of ans list
    int sum = 0;
    int carry = 0;
    /* Iterate while there are nodes in l1 or l2,
    or there's a carry to process */
    while (l1 != null || l2 != null || carry != 0) {
      sum = carry; // add carry to sum
      // add l1's node if available
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      // add l2's node if available
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      // create a new node with the result value and attach it to ans list
      ListNode newNode = new ListNode(sum % 10);
      carry = sum / 10; // calculate carry for current sum operation
      tail.next = newNode;
      tail = newNode;
    }
    return dummyHead.next; // return the head of the ans list
  }
}

// T.C => O(max(n, m)) where n and m are size of linked list l1 & l2 respectively
// S.C => O(max(n, m)) where n and m are size of linked list l1 & l2 respectively
