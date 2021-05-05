package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 中等
 *
 * @author lifeng
 */
public class DetectCycle {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 检测是否存在环，如果存在，返回入口
     * 否则，返回Null
     *
     * 1.常规来说，可以使用hash表来做
     * 2.使用快慢指针，没有额外空间消耗
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else{
                return null;
            }

            // 快慢指针相遇的点在环上
            // 假设起点到环入口：，入口到相遇点：b，c代表相遇点到入口，即：b+c表示环的一圈
            // 从快慢指针的关系：2(a+b)=a+k(b+c)+b => a=c + (k-1)(b+c)
            // 快慢相遇之后，cur从头开始遍历,最终必将和慢指针在入口相遇(a长度代表达到入口)
            if(slow == fast){
                ListNode cur = head;
                while (cur != slow){
                    slow = slow.next;
                    cur = cur.next;
                }
                return cur;
            }

        }

        return null;
    }

}
