package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 困难
 *
 * @author lifeng
 */
public class MergeKList {

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
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsIteration(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        // 步长每次翻倍
        for (int step = 1; step < len; step *= 2) {

            // 区间内每2个链表进行合并(i和i-step进行合并，因此，下一个合并终止下标是i+2*step，否则当前i就会被合并2次)
            for (int i = step; i < len; i += 2 * step) {
                lists[i - step] = merge2List(lists[i - step], lists[i]);
            }
        }
        return lists[0];
    }

    /**
     * 1.逐个进行合并
     * 2.分治法进行合并
     * 递归写法
     *
     * @param lists
     * @return
     */
    public ListNode mergeKListsRecursion(ListNode[] lists) {
        return mergeRecursion(lists, 0, lists.length - 1);
    }

    private ListNode mergeRecursion(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 2;
        return merge2List(mergeRecursion(lists, l, mid), mergeRecursion(lists, mid + 1, r));
    }

    private ListNode merge2List(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        cur.next = a != null ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        {
            MergeKList solution = new MergeKList();
            ListNode[] arrs = new ListNode[3];
            solution.mergeKListsRecursion(arrs);
        }
    }

}
