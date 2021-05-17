package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 中等
 *
 * @author lifeng
 */
public class LengthOfLTS {

    /**
     * dp[j] = max{dp[i],0<=i<j} + 1,nums[i] < nums[j]
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length, maxAns = 1;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        {
            LengthOfLTS solution = new LengthOfLTS();
            int[] nums = new int[]{
                    10, 9, 2, 5, 3, 7, 101, 18
            };
            // 4
            System.out.println(solution.lengthOfLIS(nums));
        }

        {
            LengthOfLTS solution = new LengthOfLTS();
            int[] nums = new int[]{
                    0, 1, 0, 3, 2, 3
            };
            // 4
            System.out.println(solution.lengthOfLIS(nums));
        }

        {
            LengthOfLTS solution = new LengthOfLTS();
            int[] nums = new int[]{
                    7, 7, 7, 7, 7, 7, 7
            };
            // 1
            System.out.println(solution.lengthOfLIS(nums));
        }
    }

}
