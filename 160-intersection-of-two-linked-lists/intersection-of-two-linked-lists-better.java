// Better

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
    public ListNode getIntersection(ListNode smallerListHead, ListNode longerListHead, int diff) {
        // Increment pointer of longer list by 'diff' steps
        while (diff != 0) {
            longerListHead = longerListHead.next;
            diff--;
        }
        // Now as both pointers are aligned together, check for the intersection point
        while (longerListHead != smallerListHead) {
            longerListHead = longerListHead.next;
            smallerListHead = smallerListHead.next;
        }
        // Return the intersection point
        return longerListHead;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0; int n2 = 0;
        ListNode temp = headA;
        // Calculate the size of LL A
        while (temp != null) {
            n1++;
            temp = temp.next;
        }
        temp = headB;
        // Calculate the size of LL B
        while (temp != null) {
            n2++;
            temp = temp.next;
        }
        // If LL A is smaller than LL B, then move pointer on LL B by (n2 - n1) steps to align both list's pointer together
        if (n1 < n2) {
            return getIntersection(headA, headB, n2 - n1);
        }
        // If LL B is smaller than LL A, then move pointer on LL A by (n1 - n2) steps to align both list's pointer together
        return getIntersection(headB, headA, n1 - n2);
    }
}


// T.C => O(n1) + O(n2) + O(n2 - n1) + O(min(n1, n2)) = O(n1) + O(n2) + O(n2 - n1) + O(n1) ..{since in worst case both lists will be of same size, thus min(n1, n2) = n1} 
// Final T.C => O(n1) + O(2 * n2)
// S.C => O(1)
