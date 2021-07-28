package com.lex.leetcode.practice.alg;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/
 * 中等
 * 连续位数上，绝对值差相同的数
 * 如：
 * 输入：n = 3, k = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零
 * <p>
 * 时间复杂度：O(2^n)
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/25 下午9:45
 */
public class NumsSameConsecDiff {

    public int[] numsSameConsecDiff(int n, int k) {

        Set<Integer> candidateNumSet = new HashSet<>();
        for (int j = 1; j < 10; j++) {
            candidateNumSet.add(j);
        }

        for (int i = 1; i < n; i++) {
            Set<Integer> eleSet = new HashSet<>();
            for (Integer num : candidateNumSet) {
                int cur = num % 10;
                if (cur - k >= 0) {
                    eleSet.add(10 * num + (cur - k));
                }
                if (cur + k < 10) {
                    eleSet.add(10 * num + (cur + k));
                }
            }
            candidateNumSet = eleSet;
        }

        if (n == 1) {
            candidateNumSet.add(0);
        }

        int[] ans = new int[candidateNumSet.size()];
        int index = 0;
        for (int num : candidateNumSet) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            NumsSameConsecDiff nscd = new NumsSameConsecDiff();
            int[] ans = nscd.numsSameConsecDiff(3, 7);
            // 181,292,707,818,929
            System.out.println(ans);
        }

        {
            NumsSameConsecDiff nscd = new NumsSameConsecDiff();
            int[] ans = nscd.numsSameConsecDiff(2, 1);
            // 10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98
            System.out.println(ans);
        }

        {
            NumsSameConsecDiff nscd = new NumsSameConsecDiff();
            int[] ans = nscd.numsSameConsecDiff(2, 0);
            // 11,22,33,44,55,66,77,88,99
            System.out.println(ans);
        }
        {
            NumsSameConsecDiff nscd = new NumsSameConsecDiff();
            int[] ans = nscd.numsSameConsecDiff(2, 2);
            // 13,20,24,31,35,42,46,53,57,64,68,75,79,86,97
            System.out.println(ans);
        }

    }

}
