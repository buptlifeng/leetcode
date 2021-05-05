package com.lex.leetcode.practice.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/24 下午7:31
 */
public class LongestArithSeqLength {

    /**
     * 个数最大为：10000
     *
     * @param A
     * @return
     */
    public int longestArithSeqLengthDpArray(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int ans = 1, n = A.length;
        int[][] dp = new int[n][20001];
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < i; k++) {
                int dis = A[i] - A[k] + 10000;
                if (dp[k][dis] > 0) {
                    dp[i][dis] = Math.max(dp[i][dis], dp[k][dis] + 1);
                } else {
                    dp[i][dis] = 2;
                }
                ans = Math.max(dp[i][dis], ans);
            }
        }

        return ans;
    }

    public int longestArithSeqLength(int[] A) {
        int ans = 1, n = A.length;
        // key:数组下标i
        // val:Map key:等差为i val:最大长度
        Map<Integer, Map<Integer, Integer>> hisMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hisMap.put(i, new HashMap<>());
            // 向前遍历，寻找不同的公差序列
            for (int j = i - 1; j >= 0; j--) {
                // 每个元素只和前一个历史进行比较
                if (hisMap.get(i).containsKey(A[i] - A[j])) {
                    continue;
                }
                int curLen = hisMap.get(j).getOrDefault(A[i] - A[j], 0);
                ans = Math.max(ans, curLen + 2);
                hisMap.get(i).put(A[i] - A[j], curLen + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            LongestArithSeqLength solution = new LongestArithSeqLength();
            int[] a = new int[]{
                    3, 6, 9, 12
            };
            // 4
            System.out.println(solution.longestArithSeqLength(a));
            System.out.println(solution.longestArithSeqLengthDpArray(a));
        }

        {
            LongestArithSeqLength solution = new LongestArithSeqLength();
            int[] a = new int[]{
                    9, 4, 7, 2, 10
            };
            // 3
            System.out.println(solution.longestArithSeqLength(a));
            System.out.println(solution.longestArithSeqLengthDpArray(a));
        }

        {
            LongestArithSeqLength solution = new LongestArithSeqLength();
            int[] a = new int[]{
                    20, 1, 15, 3, 10, 5, 8
            };
            // 4
            System.out.println(solution.longestArithSeqLength(a));
            System.out.println(solution.longestArithSeqLengthDpArray(a));
        }
    }

}
