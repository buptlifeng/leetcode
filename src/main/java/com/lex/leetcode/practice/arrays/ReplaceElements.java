package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * 简单
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/6/20 下午8:50
 */
public class ReplaceElements {

    /**
     * 从右往左遍历
     * 注意，都是正数
     *
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int pre = 0;
        for (int i = n - 1; i > -1; i--) {
            if (i == n - 1) {
                pre = arr[i];
                arr[i] = -1;
            } else {
                int cur = arr[i];
                arr[i] = pre;
                if (cur > pre) {
                    pre = cur;
                }
            }
        }
        return arr;
    }

    static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int n : arr) {
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        {
            ReplaceElements re = new ReplaceElements();
            int[] arr = new int[]{
                    17, 18, 5, 4, 6, 1
            };
            // 18,6,6,6,1,-1
            re.replaceElements(arr);
            printArray(arr);
        }

        {
            ReplaceElements re = new ReplaceElements();
            int[] arr = new int[]{
                    400
            };
            // -1
            re.replaceElements(arr);
            printArray(arr);
        }
    }
}
