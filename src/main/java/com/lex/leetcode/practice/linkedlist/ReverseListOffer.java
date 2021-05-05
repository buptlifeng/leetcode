package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 简单
 *
 * @author lifeng
 */
public class ReverseListOffer {

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
     * 迭代写法
     * 注意不要形成环
     * 时间：O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        {
            ReverseListOffer solution = new ReverseListOffer();
            ListNode head = solution.build(new int[]{1, 2, 3});
            ListNode nh1 = solution.reverseList(head);
            System.out.println(nh1);
        }
    }

}
