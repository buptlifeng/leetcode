package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 简单
 */
public class GetKthFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode build(int[] nums){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int n : nums){
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 先遍历一遍，确定长度后双指针遍历
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        int firstStep = len - k;
        while (firstStep > 0){
            firstStep--;
            cur = cur.next;
        }

        return cur;
    }

    public static void main(String[] args) {
        {
            GetKthFromEnd solution = new GetKthFromEnd();
            ListNode head = solution.build(new int[]{1,2,3,4,5});
            ListNode n1 = solution.getKthFromEnd(head, 1);
            System.out.println(n1);

            ListNode n2 = solution.getKthFromEnd(head, 2);
            System.out.println(n2);

            ListNode n3 = solution.getKthFromEnd(head, 3);
            System.out.println(n3);

            ListNode n4 = solution.getKthFromEnd(head, 4);
            System.out.println(n4);

            ListNode n5 = solution.getKthFromEnd(head, 5);
            System.out.println(n5);
        }
    }

}
