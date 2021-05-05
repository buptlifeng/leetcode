package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 中等
 *
 * @author lifeng
 */
public class ReverseBetween {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
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
     * 反正[left,right]对应的链表元素序列
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next, next;
        // 将当前元素下一个元素插入到当前元素之前，需要操作r-l次即可
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        {
            ReverseBetween hs = new ReverseBetween();
            ListNode head1 = hs.build(new int[]{1, 2, 3, 4, 5});
            ListNode nh = hs.reverseBetween(head1, 2, 4);
            // 1,4,3,2,5
            System.out.println(nh);
        }

        {
            ReverseBetween hs = new ReverseBetween();
            ListNode head1 = hs.build(new int[]{5});
            ListNode nh = hs.reverseBetween(head1, 1, 1);
            // 5
            System.out.println(nh);
        }
    }
}
