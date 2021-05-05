package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 中等
 *
 * @author lifeng
 */
public class Rob {

    /**
     * 可以使用dp方法
     * 1.可以偷第t间屋子，f(t-2) + nums[t]
     * 2.不可以偷第t间屋子，f(t-1)
     * f(t) = max{f(t-1),(f(t-2) + nums[t])}
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        {
            Rob solution = new Rob();
            int[] nums = new int[]{
                    1, 2, 3, 1
            };
            System.out.println(solution.rob(nums));
        }

        {
            Rob solution = new Rob();
            int[] nums = new int[]{
                    2, 7, 9, 3, 1
            };
            System.out.println(solution.rob(nums));
        }
    }

}
