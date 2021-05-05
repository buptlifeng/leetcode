package com.lex.leetcode.practice.linkedlist;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 简单
 *
 * @author lifeng
 */
public class DeleteNode {

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
     * 节点值肯定不会重复=删除一次即可
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next, prev = dummy;
        while (cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        {
            DeleteNode solution = new DeleteNode();
            ListNode head = solution.build(new int[]{4,5,1,9});
            solution.deleteNode(head, 5);
            // 4 1 9
            System.out.println(head);
        }

        {
            DeleteNode solution = new DeleteNode();
            ListNode head = solution.build(new int[]{4,5,1,9});
            solution.deleteNode(head, 1);
            // 4 5 9
            System.out.println(head);
        }
    }

}
