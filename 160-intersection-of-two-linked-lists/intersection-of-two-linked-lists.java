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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        // Exit loop when tempA == tempB (i.e intersection point is found)
        while (tempA != tempB) {
            // Incrememt tempA and tempB in each step
            tempA = tempA.next;
            tempB = tempB.next;
            // If temp A == tempB, return tempA 
            // This condition also handles case when both tempA and tempB point to null, thus avoiding infinite loop
            if (tempA == tempB) return tempA;
            // If tempA reaches null, set tempA to head of LL B
            if (tempA == null) tempA = headB;
            // If tempB reaches null, set tempB to head of LL A
            if (tempB == null) tempB = headA;
            
        }
        // This handles case where both lists have only one node and the node is same
        return tempA;
    }
}
