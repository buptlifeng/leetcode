package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 简单
 * 合并2个有序链表
 */
public class Merge2LinkedList {

    /**
     * 2个升序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curNode = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        if (l1 != null) {
            curNode.next = l1;
        }

        if (l2 != null) {
            curNode.next = l2;
        }

        return dummyHead.next;
    }

    public class ListNode {
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
}
