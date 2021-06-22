package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 简单
 *
 * @author lifeng
 */
public class MiddleNode {

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
     * 返回中间节点
     * 如果有2个，返回第二个
     * <p>
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            if (fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                // 偶数个情况
                return slow.next;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        {
            MiddleNode solution = new MiddleNode();
            int[] arr = new int[]{
                    1, 2, 3, 4, 5
            };
            ListNode head = solution.build(arr);
            System.out.println(solution.middleNode(head).val);
        }

        {
            MiddleNode solution = new MiddleNode();
            int[] arr = new int[]{
                    1, 2, 3, 4, 5, 6
            };
            ListNode head = solution.build(arr);
            System.out.println(solution.middleNode(head).val);
        }
    }

}
