package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 中等
 * 交换2个相邻的元素
 * 需要进行实际的元素交换，而不是交换值
 */
public class SwapPairs {

    /**
     * 1个普通链表
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preNode = dummyHead;
        while (preNode.next != null) {

            ListNode firstNode = preNode.next;
            ListNode secNode = firstNode.next;
            if (secNode != null) {
                ListNode next = secNode.next;
                // start swap
                preNode.next = secNode;
                secNode.next = firstNode;
                preNode = firstNode;
                preNode.next = next;
            } else {
                // end
                preNode = firstNode;
            }
        }

        return dummyHead.next;
    }

    public class ListNode {
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

    public ListNode gen(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    private static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SwapPairs solution = new SwapPairs();
        ListNode head = solution.gen(new int[]{
                1, 2, 3, 4
        });
        ListNode newhead = solution.swapPairs(head);
        printListNode(newhead);

        ListNode head1 = solution.gen(new int[]{1, 2, 3});
        ListNode newhead1 = solution.swapPairs(head1);
        printListNode(newhead1);

        ListNode head2 = solution.gen(new int[]{1});
        ListNode newhead2 = solution.swapPairs(head2);
        printListNode(newhead2);

        ListNode head3 = solution.gen(new int[]{});
        ListNode newhead3 = solution.swapPairs(head3);
        printListNode(newhead3);
    }

}
