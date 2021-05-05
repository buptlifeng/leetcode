package com.lex.leetcode.practice.arrays;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/assign-cookies
 * 简单
 *
 * @author lifeng
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gLen = g.length, sLen = s.length, total = 0;
        for (int i = 0, j = 0; i < gLen && j < sLen; i++, j++) {

            // 胃口不满足
            while (j < sLen && g[i] > s[j]) {
                j++;
            }

            if (j < sLen) {
                total++;
            }

        }

        return total;
    }

    public static void main(String[] args) {
        {
            FindContentChildren solution = new FindContentChildren();
            int[] g = new int[]{1, 2, 3};
            int[] s = new int[]{1, 1};
            System.out.println(solution.findContentChildren(g, s));
        }

        {
            FindContentChildren solution = new FindContentChildren();
            int[] g = new int[]{1, 2};
            int[] s = new int[]{1, 2, 3};
            System.out.println(solution.findContentChildren(g, s));
        }
    }

}
