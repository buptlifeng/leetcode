package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 中等
 * 起始位置不同，相同的字符串也被认为是不同的子串
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/6/17 下午10:05
 */
public class CountSubstrings {

    /**
     * dp[i,j]表示下标从i,j的子串，如果是回文串，则为true
     * 可知：
     * dp[i,j]=dp[i+1,j-1] && s[i]==s[j]
     * 最终求出dp[]有多少个元素为true即可
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int ans = 0;
        for (int st = 0; st < n; st++) {
            for (int i = 0; i + st < n; i++) {
                if (st == 0) {
                    dp[i][i] = true;
                } else if (st == 1) {
                    dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                } else {
                    dp[i][i + st] = dp[i + 1][i + st - 1] && s.charAt(i) == s.charAt(i + st);
                }
                if (dp[i][i + st]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            CountSubstrings cs = new CountSubstrings();
            // 3
            System.out.println(cs.countSubstrings("abc"));
        }

        {
            CountSubstrings cs = new CountSubstrings();
            // 6
            // a a a aa aa aaa
            System.out.println(cs.countSubstrings("aaa"));
        }

        {
            CountSubstrings cs = new CountSubstrings();
            // 11
            System.out.println(cs.countSubstrings("abaaba"));
        }
    }

}
