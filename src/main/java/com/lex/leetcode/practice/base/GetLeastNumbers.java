package com.lex.leetcode.practice.base;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 简单
 * 堆排序
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/5 下午3:54
 */
public class GetLeastNumbers {

    public int[] getLeastNumbersPriority(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap.peek()) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }

        return ans;
    }

    /**
     * 找出最小的K个数
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int hs = arr.length, len = arr.length;
        buildHeap(arr, hs);
        for (int i = len - 1; i >= len - k + 1; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, i, --hs);
        }

        return Arrays.copyOf(arr, k);
    }

    private void buildHeap(int[] arr, int hs) {
        for (int i = hs / 2; i >= 0; i--) {
            maxHeapify(arr, i, hs);
        }
    }

    private void maxHeapify(int[] arr, int i, int hs) {
        int lc = 2 * i + 1, rc = 2 * i + 2, max = i;
        if (lc < hs && arr[lc] > arr[max]) {
            max = lc;
        }
        if (rc < hs && arr[rc] > arr[max]) {
            max = rc;
        }
        if (max != i) {
            swap(arr, i, max);
            maxHeapify(arr, max, hs);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {

        {
            GetLeastNumbers solution = new GetLeastNumbers();
            int[] arr = new int[]{
                    0, 1, 2, 1
            };
            int[] ans1 = solution.getLeastNumbers(arr, 1);
            int[] ans2 = solution.getLeastNumbersPriority(arr, 1);
            System.out.println(ans1);
            System.out.println(ans2);
        }

        {
            GetLeastNumbers solution = new GetLeastNumbers();
            int[] arr = new int[]{
                    3, 2, 1
            };

            int[] ans1 = solution.getLeastNumbers(arr, 2);
            int[] ans2 = solution.getLeastNumbersPriority(arr, 2);
            System.out.println(ans1);
            System.out.println(ans2);
        }

    }

}
