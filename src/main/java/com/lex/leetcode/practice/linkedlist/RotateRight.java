package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/rotate-list/
 * 中等
 *
 * @author lifeng
 */
public class RotateRight {

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
     * 找到第n-(k%n)个节点，将其后继节点当做头结点，然后遍历至尾结点，将head挂载上去
     * 注意，设置新尾结点next=null
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        int kk = n - k % n;
        if(kk % n == 0){
            return head;
        }
        cur = head;
        ListNode pre = null;
        while (kk > 0){
            kk--;
            pre = cur;
            cur = cur.next;
        }

        ListNode nh = cur;
        // 避免形成环
        pre.next = null;

        while (cur.next != null){
            cur = cur.next;
        }
        // cur 代表尾结点
        cur.next = head;
        return nh;
    }

    public static void main(String[] args) {
        {
            RotateRight solution = new RotateRight();
            ListNode head = solution.build(new int[]{1});
            ListNode nh = solution.rotateRight(head,0);
            // 1
            System.out.println(nh);
        }

        {
            RotateRight solution = new RotateRight();
            ListNode head = solution.build(new int[]{1, 2, 3, 4, 5});
            ListNode nh = solution.rotateRight(head,2);
            // 4,5,1,2,3
            System.out.println(nh);
        }

        {
            RotateRight solution = new RotateRight();
            ListNode head = solution.build(new int[]{0,1,2});
            ListNode nh = solution.rotateRight(head,4);
            // 2,0,1
            System.out.println(nh);
        }
    }

}
