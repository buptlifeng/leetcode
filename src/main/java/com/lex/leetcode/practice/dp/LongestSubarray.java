package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 * 中等
 * <p>
 * 典型的DP或者窗口方法都可以解决
 * <p>
 * 关键词：
 * DP 窗口
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/22 下午10:08
 */
public class LongestSubarray {

    /**
     * 需要求移除一个0之后，最长的连续1序列
     * 必须删除一个元素
     * 思路：
     * dpLeft[i]从左到右，截止的连续1序列
     * dpRight[j]从右到左，截止的连续1序列
     * dpLeft和dpRight的最大值是相同的
     * 求：max{dpLeft[i], nums[i]==0时，dpLeft[i-1]>0 && dpRight[i+1]}
     *
     * @param nums
     * @return
     */
    public int longestSubarrayDPTOnSOn(int[] nums) {
        int n = nums.length;
        //表示nums[i] == 1
        int[] dpl = new int[n];
        dpl[0] = nums[0];

        int[] dpr = new int[n];
        dpr[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            dpl[i] = nums[i] == 1 ? (dpl[i - 1] + 1) : 0;
        }

        for (int j = n - 2; j >= 0; j--) {
            dpr[j] = nums[j] == 1 ? (dpr[j + 1] + 1) : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,
                    (i > 0 ? dpl[i - 1] : 0) + (i < n - 1 ? dpr[i + 1] : 0));
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    1, 1, 0, 1
            };
            // 3
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }

        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    0, 1, 1, 1, 0, 1, 1, 0, 1
            };
            // 5
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }

        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    1, 1, 1
            };
            // 2
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }

        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    1, 1, 0, 0, 1, 1, 1, 0, 1
            };
            // 4
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }

        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    0, 0, 0
            };
            // 0
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }

        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    1, 1, 1, 1
            };
            // 3
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }

        {
            LongestSubarray ls = new LongestSubarray();
            int[] nums = new int[]{
                    1, 1, 1, 1, 1
            };
            // 4
            System.out.println(ls.longestSubarrayDPTOnSOn(nums));
        }
    }

}
