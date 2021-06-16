package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/partition-list/
 * 中等
 *
 * @author lifeng
 */
public class PartitionLinkedList {

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

    public static ListNode build(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 声明2个单独的链表，进行遍历
     * node.val>=x 算一种情况
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode sh = small;
        ListNode large = new ListNode(-1);
        ListNode lh = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = lh.next;
        return sh.next;
    }

    public static void main(String[] args) {

        {
            PartitionLinkedList solution = new PartitionLinkedList();
            ListNode h = build(new int[]{
                    1, 4, 3, 2, 5, 2
            });
            ListNode head = solution.partition(h, 3);
            // 1 2 2 4 3 5
            System.out.println(head);
        }

        {
            PartitionLinkedList solution = new PartitionLinkedList();
            ListNode h = build(new int[]{
                    1, 4, 3, 2, 5, 3
            });
            ListNode head = solution.partition(h, 3);
            // 1 2 3 3 4 5
            System.out.println(head);
        }

        {
            PartitionLinkedList solution = new PartitionLinkedList();
            ListNode h = build(new int[]{
                    2, 1
            });
            ListNode head = solution.partition(h, 2);
            // 1 2
            System.out.println(head);
        }

    }

}
