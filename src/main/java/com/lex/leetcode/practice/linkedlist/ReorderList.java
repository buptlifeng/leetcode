package com.lex.leetcode.practice.linkedlist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 中等
 *
 * @author lifeng
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode build(int[] arrays) {
        ListNode h = new ListNode(-1);
        ListNode t = h;
        for (int val : arrays) {
            t.next = new ListNode(val);
            t = t.next;
        }
        return h.next;
    }

    public void reorderListOnOn(ListNode head) {
        int len = 0;
        ListNode halfNode = head;
        while (halfNode != null) {
            len++;
            halfNode = halfNode.next;
        }
        int mid = (len - 1) / 2 + 1;
        Stack<ListNode> stack = new Stack<>();
        halfNode = head;
        while (mid > 0) {
            halfNode = halfNode.next;
            mid--;
        }
        // 找到后半部分链表
        ListNode p = halfNode;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        // 准备合并2个链表
        ListNode nh = head;
        while (!stack.isEmpty()) {
            ListNode next = nh.next;
            nh.next = stack.pop();
            nh.next.next = next;
            nh = next;
        }
        // 断开环
        nh.next = null;
    }


    /**
     * 将链表的后半部逆序
     * 然后合并2个链表-交叉合并即可
     * <p>
     * 效率：
     * 时间：O(n)
     * 空间：O(n)
     * <p>
     * 可以改造成:原地逆序后半部分
     * 时间：O(n)
     * 空间：O(1)
     *
     * @param head
     */
    public void reorderListOnO1(ListNode head) {
        int len = 0;
        ListNode halfNode = head;
        while (halfNode != null) {
            len++;
            halfNode = halfNode.next;
        }
        int mid = (len - 1) / 2;
        halfNode = head;
        while (mid > 0) {
            halfNode = halfNode.next;
            mid--;
        }
        // 找到后半部分链表
        ListNode p = halfNode.next;
        halfNode.next = null;
        // 逆序后的后半部分新表头
        ListNode halfHead = reverse(p);

        // 准备合并2个链表
        ListNode nh = head;
        while (halfHead != null && nh != null) {
            ListNode halfNext = halfHead.next;
            ListNode next = nh.next;
            nh.next = halfHead;
            nh.next.next = next;

            // 2个链表都遍历到下一个节点
            halfHead = halfNext;
            nh = next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        while (head != null) {
            ListNode n1 = dummyHead.next, n2 = head.next;
            dummyHead.next = head;
            dummyHead.next.next = n1;
            head = n2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        {
            ReorderList solution = new ReorderList();
            ListNode head = solution.build(new int[]{1, 2, 3, 4, 5});
            solution.reorderListOnO1(head);
            // 1,5,2,4,3
            System.out.println(head);
        }

        {
            ReorderList solution = new ReorderList();
            ListNode head = solution.build(new int[]{1, 2, 3, 4});
            solution.reorderListOnO1(head);
            // 1,4,2,3
            System.out.println(head);
        }

        {
            ReorderList solution = new ReorderList();
            ListNode head = solution.build(new int[]{1, 2, 3, 4, 5});
            solution.reorderListOnOn(head);
            // 1,5,2,4,3
            System.out.println(head);
        }

        {
            ReorderList solution = new ReorderList();
            ListNode head = solution.build(new int[]{1, 2, 3, 4});
            solution.reorderListOnOn(head);
            // 1,4,2,3
            System.out.println(head);
        }
    }

}
