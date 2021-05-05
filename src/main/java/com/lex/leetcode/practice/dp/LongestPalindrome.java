package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 中等
 *
 * @author lifeng
 */
public class LongestPalindrome {

    /**
     * 找到最长的回文串
     * 假设dp[i,j]为一个回文串的长度（下标i-j），则：dp[i-1,j+1]=
     * 1.如果s[i-1] == s[j+1],dp[i-1,j+1] = dp[i,j]+1;
     * 2.否则，dp[i-1,j+1]=0;
     * <p>
     * 最终，求dp[i,j]最大值时，[i,j]下标对应的值;
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // 外层循环控制步长 步长一定要从小到大
        for (int step = 0; step < n; step++) {
            // 内层从0开始，根据步长计算是否为回文串
            for (int i = 0; i + step < n; i++) {
                int j = i + step;
                if (step == 0) {
                    dp[i][j] = true;
                } else if (step == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    // dp[i+1][j-1] 在步长更短的时候已经计算出来了
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                // 如果是回文，且最大长度变化了，更新最长回文串
                if (dp[i][j] && (step + 1 > ans.length())) {
                    ans = s.substring(i, i + step + 1);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            LongestPalindrome lp = new LongestPalindrome();
            System.out.println(lp.longestPalindrome("abcd"));
        }

        {
            LongestPalindrome lp = new LongestPalindrome();
            System.out.println(lp.longestPalindrome("ababcdcba"));
        }
    }

}
