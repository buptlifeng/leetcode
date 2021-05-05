package com.lex.leetcode.practice.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * 中等
 *
 * @author lifeng
 */
public class AddTwoNumbersII {

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

    /**
     * 表头是高位元素，因此，考虑使用栈的结构
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }

        // 是否进位
        int add = 0;
        List<Integer> list = new ArrayList<>();
        while (s1.size() > 0 || s2.size() > 0) {
            int v1 = 0, v2 = 0;
            if (!s1.isEmpty()) {
                v1 = s1.pop();
            }
            if (!s2.isEmpty()) {
                v2 = s2.pop();
            }
            int sum = v1 + v2 + add;
            if (sum > 9) {
                sum -= 10;
                add = 1;
            } else {
                add = 0;
            }
            list.add(sum);
        }

        if (add > 0) {
            list.add(add);
        }

        ListNode head = new ListNode(-1);
        ListNode point = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            point.next = new ListNode(list.get(i));
            point = point.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        {
            AddTwoNumbersII solution = new AddTwoNumbersII();
            ListNode l1 = new ListNode(2);
            ListNode l11 = new ListNode(4);
            ListNode l12 = new ListNode(3);
            l1.next = l11;
            l11.next = l12;

            ListNode l2 = new ListNode(5);
            ListNode l21 = new ListNode(6);
            ListNode l22 = new ListNode(4);
            l2.next = l21;
            l21.next = l22;
            ListNode head = solution.addTwoNumbers(l1, l2);
            System.out.println(head);
        }

        {
            AddTwoNumbersII solution = new AddTwoNumbersII();
            ListNode l1 = new ListNode(2);
            ListNode l11 = new ListNode(4);
            ListNode l12 = new ListNode(9);
            l1.next = l11;
            l11.next = l12;

            ListNode l2 = new ListNode(5);
            ListNode l21 = new ListNode(6);
            ListNode l22 = new ListNode(4);
            ListNode l23 = new ListNode(9);
            l2.next = l21;
            l21.next = l22;
            l22.next = l23;
            ListNode head = solution.addTwoNumbers(l1, l2);
            System.out.println(head);
        }

    }

}
