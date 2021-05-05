package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 中等
 *
 * @author lifeng
 */
public class RemoveNthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode cur = this;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.val).append(" ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public ListNode build(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 尝试一次遍历解决该问题
     * len(list) = n，则 1<=k<=n
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy, slow = dummy;
        int s = k;
        while (s > 0) {
            fast = fast.next;
            s--;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // slow是待删除节点的前驱
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        {
            RemoveNthFromEnd solution = new RemoveNthFromEnd();
            ListNode head = solution.build(new int[]{
                    1, 2, 3, 4, 5
            });
            ListNode nh = solution.removeNthFromEnd(head, 2);
            // 1 2 3 5
            System.out.println(nh.toString());
        }

        {
            RemoveNthFromEnd solution = new RemoveNthFromEnd();
            ListNode head = solution.build(new int[]{
                    1, 2, 3, 4, 5
            });
            ListNode nh = solution.removeNthFromEnd(head, 1);
            // 1 2 3 4
            System.out.println(nh.toString());
        }

        {
            RemoveNthFromEnd solution = new RemoveNthFromEnd();
            ListNode head = solution.build(new int[]{
                    1, 2, 3, 4, 5
            });
            ListNode nh = solution.removeNthFromEnd(head, 5);
            // 2 3 4 5
            System.out.println(nh.toString());
        }

        {
            RemoveNthFromEnd solution = new RemoveNthFromEnd();
            ListNode head = solution.build(new int[]{
                    1
            });
            ListNode nh = solution.removeNthFromEnd(head, 1);
            // []
            System.out.println(nh == null);
        }

    }

}
