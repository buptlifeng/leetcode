package com.lex.leetcode.practice.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4
 * 中等
 * <p>
 * 最长连续无重复元素子序列
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/30 上午10:05
 */
public class MaxLength {

    public int maxLength(int[] arr) {
        int ans = 1, n = arr.length;
        Set<Integer> set = new HashSet<>();
        int l = 0;
        while (l < n) {
            int r = l;
            while (r < n && !set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
            }
            ans = Math.max(r - l, ans);
            l++;
            // clear set
            set.clear();
        }
        return ans;
    }

    /**
     * 双指针
     *
     * @param arr
     * @return
     */
    public int maxLengthDoublePoint(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int ans = 1, n = arr.length, r = -1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                // remove pre element
                set.remove(arr[i - 1]);
            }
            // move right point and check
            // 因为i已经+1，因此[i,r]的最大长度当前是ans-1，尝试右移
            while (r + 1 < n && !set.contains(arr[r + 1])) {
                set.add(arr[r + 1]);
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            MaxLength ml = new MaxLength();
            int[] arr = new int[]{
                    2, 3, 4, 5
            };
            // 4
            System.out.println(ml.maxLength(arr));
            System.out.println(ml.maxLengthDoublePoint(arr));
        }

        {
            MaxLength ml = new MaxLength();
            int[] arr = new int[]{
                    2, 2, 3, 4, 3
            };
            // 3
            System.out.println(ml.maxLength(arr));
            System.out.println(ml.maxLengthDoublePoint(arr));
        }

        {
            MaxLength ml = new MaxLength();
            int[] arr = new int[]{
                    9
            };
            // 1
            System.out.println(ml.maxLength(arr));
            System.out.println(ml.maxLengthDoublePoint(arr));
        }

        {
            MaxLength ml = new MaxLength();
            int[] arr = new int[]{
                    1, 2, 3, 1, 2, 3, 2, 2
            };
            // 3
            System.out.println(ml.maxLength(arr));
            System.out.println(ml.maxLengthDoublePoint(arr));
        }

        {
            MaxLength ml = new MaxLength();
            int[] arr = new int[]{
                    2, 2, 3, 4, 8, 99, 3
            };
            // 5
            System.out.println(ml.maxLength(arr));
            System.out.println(ml.maxLengthDoublePoint(arr));
        }
    }

}
