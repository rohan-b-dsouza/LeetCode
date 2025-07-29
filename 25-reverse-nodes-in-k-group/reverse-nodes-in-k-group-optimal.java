// Optimal

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
    // Function to reverse a LL
  public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null; // pointer for previous node
        ListNode next = null; // pointer for next node
        ListNode temp = head; // pointer for current node
        while (temp != null) {
            next = temp.next; // store pointer to next node of current
            temp.next = prev; // link current node to previous
            prev = temp; // update prev node to current node
            temp = next; // increment temp to next node
        }
        return prev; // return head of reverse LL
    }
    // Function to get the kth node
  public ListNode getKthNode(ListNode temp, int k) {
    // Decrement counter by 1
    k--;
    // Get kth node by incrememting pointer till k is non - zero and pointer is not null
    while (temp != null && k > 0) {
      temp = temp.next;
      k--;
    }
    // Return the kth node
    return temp;
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    // Initialize a temporary pointer to traverse the list
    ListNode temp = head;
    /* Initialize pointers to track the first node of next group and
    last node of previous group */
    ListNode nextNode = null;
    ListNode prevNode = null;
    // Traverse through the linked list
    while (temp != null) {
      // Get the kth node of the current group
      ListNode kthNode = getKthNode(temp, k);
      // If the kth node is null i.e not a complete group
      if (kthNode == null) {
        /* If there was a previous group, link its last node to the current node, and return the head*/
        if (prevNode != null) prevNode.next = temp;
        // If there was no previous group, i.e there is no eligible group in this LL, return the
        // head
        return head;
      }
      /*Store the first node of next group*/
      nextNode = kthNode.next;
      // Disconnect the current group from next group, for reversal
      kthNode.next = null;
      // Reverse the current group
      reverseList(temp);
      // If it was the first group (temp == head), then set kthNode as the head of the LL
      if (temp == head) {
        head = kthNode;
        /*If its not the first group, then attach previous group to the current reverse group*/
      } else {
        prevNode.next = kthNode;
      }
      /* Update the previous node to the current reversed group's last node and temp to the next group's first node */
      prevNode = temp;
      temp = nextNode;
    }
    return head;
  }
}

// T.C => O(2 * n) = O(n) ---------{O(n) for reversing and O(n) for finding kth node}
// S.C => O(1)
