package com.lex.leetcode.practice.alg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 * 简单
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/25 下午9:15
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, p = 0;
        int[] ans = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int value : nums2) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                map.put(deque.removeLast(), value);
            }
            deque.addLast(value);
        }

        for (int i = 0; i < m; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            NextGreaterElement nge = new NextGreaterElement();
            int[] num1 = new int[]{
                    4, 1, 2
            };
            int[] num2 = new int[]{
                    1, 3, 4, 2
            };
            int[] num3 = nge.nextGreaterElement(num1, num2);
            System.out.println(num3);
        }

        {
            NextGreaterElement nge = new NextGreaterElement();
            int[] num1 = new int[]{
                    2, 4
            };
            int[] num2 = new int[]{
                    1, 2, 3, 4
            };
            int[] num3 = nge.nextGreaterElement(num1, num2);
            System.out.println(num3);
        }
    }
}
