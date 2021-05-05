package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 中等
 * 要求：O(n log n) 时间复杂度和常数级空间复杂度下
 *
 * @author lifeng
 */
public class SortList {

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

    /**
     * 自顶向下
     * 1.找到中点，拆分成2个子序列
     * 2.子序列排序
     * 3.合并
     * <p>
     * 时间：o(nlogn)
     * 空间：o(logn)
     *
     * @param head
     * @return
     */
    public ListNode sortListWithUp2Bottom(ListNode head) {
        return sortListWithUp2Bottom(head, null);
    }

    /**
     * 自底向上
     * 1.sublen=1,每个子序列肯定有序
     * 2.sublen加倍，对每个子序列进行排序，然后合并
     * 3.合并
     * <p>
     * 时间：o(nlogn)
     * 空间：o(1)
     *
     * @param head
     * @return
     */
    public ListNode sortListWithBottom2Up(ListNode head) {
        if (head == null) {
            return head;
        }

        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        for (int subLength = 1; subLength < len; subLength <<= 2) {
            ListNode prev = dummy, curr = dummy.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                // 获取第二段子序列
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }

                ListNode next = null;
                if (curr.next != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 合并2个子序列，并挂在在首节点后
                prev.next = merge(head1, head2);
                // 遍历到本次序列后的最后一个元素
                while (prev.next != null) {
                    prev = prev.next;
                }
                // 从下一段重新开始读取2个子序列进行合并
                curr = next;
            }
        }

        return dummy.next;
    }

    ListNode sortListWithUp2Bottom(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (slow != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortListWithUp2Bottom(head, mid);
        ListNode list2 = sortListWithUp2Bottom(mid, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy, temp1 = list1, temp2 = list2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummy.next;
    }

}
