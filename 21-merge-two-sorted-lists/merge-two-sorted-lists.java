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
    while (temp != null) {
      list.add(temp.val);
      temp = temp.next;
    }
    temp = list2;
    while (temp != null) {
        list.add(temp.val);
        temp = temp.next;
    }
    Collections.sort(list);
    ListNode dummyNode = new ListNode(-1);
    temp = dummyNode;
    for (int num : list) {
        temp.next = new ListNode(num);
        temp = temp.next;
    }
    return dummyNode.next;

  }
}
