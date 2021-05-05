package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 简单
 *
 * @author lifeng
 */
public class MaxSubArrays {

    /**
     * DP方法
     *
     * @param nums
     * @return
     */
    public int maxSubArraySpaceOn(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, dp[i + 1]);
        }

        return ans;
    }

    public int maxSubArraySpaceO1(int[] nums) {
        int preSum = 0, ans = nums[0];
        for (int n : nums) {
            preSum = Math.max(n, preSum + n);
            ans = Math.max(ans, preSum);
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            MaxSubArrays msa = new MaxSubArrays();
            int[] nums = new int[]{
                    -2, 1, -3, 4, -1, 2, 1, -5, 4
            };
            // 6 [4,-1,2,1]
            System.out.println(msa.maxSubArraySpaceOn(nums));
            System.out.println(msa.maxSubArraySpaceO1(nums));
        }

        {
            MaxSubArrays msa = new MaxSubArrays();
            int[] nums = new int[]{
                    1
            };
            // 1 [1]
            System.out.println(msa.maxSubArraySpaceOn(nums));
            System.out.println(msa.maxSubArraySpaceO1(nums));
        }

        {
            MaxSubArrays msa = new MaxSubArrays();
            int[] nums = new int[]{
                    -1
            };
            // -1 [-1]
            System.out.println(msa.maxSubArraySpaceOn(nums));
            System.out.println(msa.maxSubArraySpaceO1(nums));
        }

        {
            MaxSubArrays msa = new MaxSubArrays();
            int[] nums = new int[]{
                    0
            };
            // 0 [0]
            System.out.println(msa.maxSubArraySpaceOn(nums));
            System.out.println(msa.maxSubArraySpaceO1(nums));
        }

        {
            MaxSubArrays msa = new MaxSubArrays();
            int[] nums = new int[]{
                    -100000
            };
            // -100000 [-100000]
            System.out.println(msa.maxSubArraySpaceOn(nums));
            System.out.println(msa.maxSubArraySpaceO1(nums));
        }
    }

}
