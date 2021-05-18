package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/17 下午9:59
 */
public class OddEvenList {

    static class ListNode {
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
     * 先把2个链表拆分出来，然后进行合并即可
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode oc = dummyOdd, ec = dummyEven;
        int no = 1;
        while (head != null) {
            if (no % 2 == 1) {
                oc.next = head;
                oc = oc.next;
            } else {
                ec.next = head;
                ec = ec.next;
            }
            no++;
            head = head.next;
        }
        oc.next = dummyEven.next;
        ec.next = null;
        return dummyOdd.next;
    }

    public static void main(String[] args) {
        {
            OddEvenList solution = new OddEvenList();
            ListNode head = solution.build(new int[]{
                    1, 2, 3, 4, 5
            });
            ListNode nh = solution.oddEvenList(head);
            System.out.println(nh);
        }

        {
            OddEvenList solution = new OddEvenList();
            ListNode head = solution.build(new int[]{
                    2, 1, 3, 5, 6, 4, 7
            });
            ListNode nh = solution.oddEvenList(head);
            System.out.println(nh);
        }
    }
}
