// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

// Iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null){
            ListNode curr = new ListNode(head.val);
            curr.next = prev;
            prev = curr;
            head = head.next;
        }
        return prev;
    }
}

// Iterative (in-place)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
