package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 困难
 *
 * @author lifeng
 */
public class ReverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode build(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }


    /**
     * 每K个节点为一组，每组进行翻转
     * 每次组内进行翻转
     * 最后不足K个，不进行翻转
     *
     * @param head
     * @param k    不大于链表长度
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curHead = head, preTail = null, finalHead = null;
        while (curHead != null) {
            int n = 0;
            ListNode cur = curHead;
            while (cur != null && n < k) {
                n++;
                cur = cur.next;
            }

            if (n == k) {
                ListNode nHead = reverse(curHead, cur);
                if (preTail == null) {
                    // 第一次记录头结点
                    finalHead = nHead;
                } else {
                    // 挂载新的链表
                    preTail.next = nHead;
                }
                // 更新
                preTail = curHead;
            }else{
                if(preTail != null){
                    preTail.next = curHead;
                }else{
                    preTail = curHead;
                }
            }
            curHead = cur;
        }
        return finalHead;
    }

    /**
     * 将nhead开头的元素进行翻转，直到元素是nextHead为止
     *
     * @param p
     * @param nextHead
     * @return
     */
    private ListNode reverse(ListNode p, ListNode nextHead) {
        ListNode nh = new ListNode(-1);
        while (p != null && p != nextHead) {
            ListNode pNext = p.next, hNext = nh.next;
            nh.next = p;
            nh.next.next = hNext;
            p = pNext;
        }
        return nh.next;
    }

    public static void main(String[] args) {
        {
            ReverseKGroup solution = new ReverseKGroup();
            ListNode head = solution.build(new int[]{1, 2, 3, 4, 5});
            ListNode nh = solution.reverseKGroup(head, 2);
            System.out.println(nh);
        }

        {
            ReverseKGroup solution = new ReverseKGroup();
            ListNode head = solution.build(new int[]{1, 2, 3, 4, 5});
            ListNode nh = solution.reverseKGroup(head, 3);
            System.out.println(nh);
        }

        {
            ReverseKGroup solution = new ReverseKGroup();
            ListNode head = solution.build(new int[]{1, 2, 3, 4, 5});
            ListNode nh = solution.reverseKGroup(head, 1);
            System.out.println(nh);
        }

        {
            ReverseKGroup solution = new ReverseKGroup();
            ListNode head = solution.build(new int[]{1});
            ListNode nh = solution.reverseKGroup(head, 1);
            System.out.println(nh);
        }
    }

}
