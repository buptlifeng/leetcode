package com.lex.leetcode.practice.arrays;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * 简单
 *
 * @author lifeng
 */
public class KthLargest {

    private PriorityQueue<Integer> heap;
    private int heapSize;

    public KthLargest(int k, int[] nums) {
        this.heapSize = k;
        this.heap = new PriorityQueue<>();
        for (int no : nums) {
            add(no);
        }
    }

    public int add(int val) {
        this.heap.offer(val);
        if (this.heap.size() > this.heapSize) {
            this.heap.poll();
        }
        return this.heap.peek();
    }

    public static void main(String[] args) {
        {
            KthLargest solution = new KthLargest(3, new int[]{
                    4, 5, 8, 2
            });
            System.out.println(solution.add(3));
            System.out.println(solution.add(5));
            System.out.println(solution.add(10));
            System.out.println(solution.add(9));
            System.out.println(solution.add(4));
        }
    }

}
