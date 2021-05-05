package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 简单
 *
 * @author lifeng
 */
public class DeleteDuplicatesI {

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
     * 升序的链表
     * 删除后每个元素只出现一次
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && next.val == cur.val){
                next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        {
            DeleteDuplicatesI solution = new DeleteDuplicatesI();
            ListNode head = solution.build(new int[]{
                    1, 2, 3, 3, 4, 4, 5
            });
            ListNode nh = solution.deleteDuplicates(head);
            // 1 2 3 4 5
            System.out.println(nh.toString());
        }

        {
            DeleteDuplicatesI solution = new DeleteDuplicatesI();
            ListNode head = solution.build(new int[]{
                    1, 1, 1
            });
            ListNode nh = solution.deleteDuplicates(head);
            // 1
            System.out.println(nh.toString());
        }

        {
            DeleteDuplicatesI solution = new DeleteDuplicatesI();
            ListNode head = solution.build(new int[]{
                    1, 1, 1, 2, 3
            });
            ListNode nh = solution.deleteDuplicates(head);
            // 1,2,3
            System.out.println(nh.toString());
        }
    }

}
