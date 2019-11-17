// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode cur = dummy.next = head;
        while (cur != null && cur.next != null){
            int val = cur.next.val;
            if (cur.val <= val){
                cur = cur.next;
                continue;
            }
            if (p.next != null && p.next.val > val){
                p = dummy;
            }
            while (p.next != null && p.next.val <= val){
                p = p.next;
            }
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
        }
        return dummy.next;
    }
}