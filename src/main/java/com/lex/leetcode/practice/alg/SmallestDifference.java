package com.lex.leetcode.practice.alg;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-difference-lcci
 * 中等
 *
 * @author lifeng
 * @date 2021-04-22 21:55
 */
public class SmallestDifference {

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        long min = Long.MAX_VALUE;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return 0;
            }
            if (a[i] > b[j]) {
                min = Math.min(min, (long) a[i] - (long) b[j++]);
            } else {
                min = Math.min(min, (long) b[j] - (long) a[i++]);
            }
        }

        return (int) min;
    }

    public static void main(String[] args) {
        {
            SmallestDifference sd = new SmallestDifference();
            int[] a = new int[]{
                    1, 3, 15, 11, 2
            };
            int[] b = new int[]{
                    23, 127, 235, 19, 8
            };
            // 3
            System.out.println(sd.smallestDifference(a, b));
        }

        {
            SmallestDifference sd = new SmallestDifference();
            int[] a = new int[]{
                    -2147483648, 1
            };
            int[] b = new int[]{
                    2147483647, 0
            };
            // 1
            System.out.println(sd.smallestDifference(a, b));
        }
    }

}
