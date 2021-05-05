package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 简单
 *
 * @author lifeng
 */
public class GetIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
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

    public int getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        int al = 0, bl = 0;
        while (ha != null) {
            al++;
            ha = ha.next;
        }

        while (hb != null) {
            bl++;
            hb = hb.next;
        }

        ha = headA;
        hb = headB;
        if (al > 0 || bl > 0) {
            while (al > bl) {
                ha = ha.next;
                al--;
            }

            while (bl > al) {
                hb = hb.next;
                bl--;
            }

            while (ha != null && hb != null) {
                if (ha.val != hb.val) {
                    ha = ha.next;
                    hb = hb.next;
                } else {
                    return ha.val;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        {
            GetIntersectionNode solution = new GetIntersectionNode();
            ListNode ha = solution.build(new int[]{4, 1, 8, 4, 5});
            ListNode hb = solution.build(new int[]{5, 0, 2, 8, 4, 5});
            System.out.println(solution.getIntersectionNode(ha, hb));

        }

        {
            GetIntersectionNode solution = new GetIntersectionNode();
            ListNode ha = solution.build(new int[]{0, 9, 1, 2, 4});
            ListNode hb = solution.build(new int[]{3, 2, 4});
            System.out.println(solution.getIntersectionNode(ha, hb));

        }

        {
            GetIntersectionNode solution = new GetIntersectionNode();
            ListNode ha = solution.build(new int[]{2, 6, 4});
            ListNode hb = solution.build(new int[]{1, 5});
            System.out.println(solution.getIntersectionNode(ha, hb));

        }
    }

}
