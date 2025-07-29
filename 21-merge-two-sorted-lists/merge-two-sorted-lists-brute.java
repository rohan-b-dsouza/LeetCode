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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode temp = list1;
    List<Integer> list = new ArrayList<>();
      // Add elements in list1 to list
    while (temp != null) {
      list.add(temp.val);
      temp = temp.next;
    }
    temp = list2;
      // Add elements in list2 in list
    while (temp != null) {
        list.add(temp.val);
        temp = temp.next;
    }
      // Sort list
    Collections.sort(list);
    ListNode dummyNode = new ListNode(-1);
    temp = dummyNode;
      // Build a linked list from the list using a dummynode
    for (int num : list) {
        temp.next = new ListNode(num);
        temp = temp.next;
    }
      // Return the head of the newly created list
    return dummyNode.next;

  }
}


// T.C => O(N) + O(N * log(N)) + O(N) -------{where N = n + m}
// S.C => O(N) + O(N) for the extra ArrayList and Linked List
