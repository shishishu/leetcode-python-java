import java.util.List;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// method 1: recursion
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode mid = findMiddle(head);
        TreeNode node = new TreeNode(mid.val);
        if (mid == head){
            return node;
        }
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode findMiddle(ListNode head){
        ListNode prevPtr = null, slowPtr = head, fastPtr = head;
        while ((fastPtr != null ) && (fastPtr.next != null)){
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (prevPtr != null){
            prevPtr.next = null;
        }
        return slowPtr;
    }
}

// method 2: inorder simulation
class Solution {

    private ListNode head;

    private int findSize(ListNode head){
        ListNode ptr = head;
        int c = 0;
        while (ptr != null){
            ptr = ptr.next;
            c += 1;
        }
        return c;
    }

    private TreeNode convertListToBST(int l, int r){
        if (l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = this.convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        node.right = this.convertListToBST(mid + 1, r);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = findSize(head);
        this.head = head;
        return convertListToBST(0, size - 1);
    }
}