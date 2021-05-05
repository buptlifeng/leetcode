package com.lex.leetcode.practice.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 中等
 *
 * @author lifeng
 */
public class AddTwoNumbers {

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
     * 直接遍历2个链表即可
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 是否进位
        int add = 0;
        List<Integer> ret = new LinkedList<>();
        while (l1 != null || l2 != null) {
            int e1 = l1 != null ? l1.val : 0;
            int e2 = l2 != null ? l2.val : 0;
            int sum = e1 + e2 + add;
            if (sum > 9) {
                sum -= 10;
                add = 1;
            } else {
                add = 0;
            }
            ret.add(sum);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 补偿进位
        if (add > 0) {
            ret.add(add);
        }

        ListNode head = new ListNode(-1);
        ListNode point = head;
        for (Integer ele : ret) {
            point.next = new ListNode(ele);
            point = point.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        {
            AddTwoNumbers solution = new AddTwoNumbers();
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
            AddTwoNumbers solution = new AddTwoNumbers();
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
