package com.lex.leetcode.practice.linkedlist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 简单
 *
 * @author lifeng
 */
public class ReverseList {

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

    /**
     * 递归写法
     * <p>
     * 假设有2个链表，第一个为原始链表a，第二个链表b
     * a = head;
     * b = null;
     * 然后遍历a找到队尾元素，将其设置为b的表头
     * 直到链表a为null
     *
     * 注意不要形成环
     * <p>
     * 时间：O(n)
     * 空间：O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head) {
        ListNode nh = new ListNode(-1);
        cur = nh;
        dfs(head);
        return nh.next;
    }

    ListNode cur = null;
    void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        // 断开环
        head.next = null;
        cur.next = head;
        cur = cur.next;
    }

    /**
     * 使用头插法
     * 每次固定将链表第一个元素挂载到dummy后面，并将当前的元素继续挂载
     * @param head
     * @return
     */
    public ListNode reverseListByInsertHead(ListNode head){
        ListNode nh = new ListNode(-1);
        // 每次固定将链表第一个元素挂载到dummy后面
        while (head != null){
            ListNode curNext = head.next, preNext = nh.next;
            nh.next = head;
            // 断开链接，避免环
            head.next = null;
            nh.next.next = preNext;
            head = curNext;
        }
        return nh.next;
    }

    /**
     * 迭代写法
     * 注意不要形成环
     * 时间：O(n)
     * 空间：O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseListIteration(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode nh = new ListNode(-1);
        ListNode cur = nh;
        while (!stack.isEmpty()){
            cur.next = stack.pop();
            cur = cur.next;
        }
        // 原始头元素，断开环
        cur.next = null;
        return nh.next;
    }

    public static void main(String[] args) {
        {
            ReverseList solution = new ReverseList();
            ListNode head = solution.build(new int[]{1, 2, 3});
            ListNode nh1 = solution.reverseListByInsertHead(head);
            System.out.println(nh1);
        }

        {
            ReverseList solution = new ReverseList();
            ListNode head = solution.build(new int[]{1, 2, 3});
            ListNode nh1 = solution.reverseListRecursion(head);
            System.out.println(nh1);
        }

        {
            ReverseList solution = new ReverseList();
            ListNode head = solution.build(new int[]{1, 2, 3});
            ListNode nh1 = solution.reverseListIteration(head);
            System.out.println(nh1);
        }
    }

}
