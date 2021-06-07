package com.lex.leetcode.practice.window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 中等
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * @author lifeng
 */
public class SubArraySum {

    /**
     * <p>
     * 不可以使用窗口方法，因为和k可能为负数
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        int ans = 0, n = nums.length;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int[] sums = new int[n];
        sums[0] = nums[0];
        // 首先计算[0,i]的和
        for (int i = 1; i < n; i++) {
            sums[i] += (sums[i - 1] + nums[i]);
        }

        sumMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            int diff = sums[i] - k;
            if (sumMap.containsKey(diff)) {
                ans += sumMap.get(diff);
            }
            sumMap.put(sums[i], sumMap.getOrDefault(sums[i], 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        {
            SubArraySum solution = new SubArraySum();
            int[] nums = new int[]{
                    1
            };
            // 0
            System.out.println(solution.subarraySum(nums, 2));
        }

        {
            SubArraySum solution = new SubArraySum();
            int[] nums = new int[]{
                    1, 1, 1
            };
            // 2
            System.out.println(solution.subarraySum(nums, 2));
        }

        {
            SubArraySum solution = new SubArraySum();
            int[] nums = new int[]{
                    1, 2, 3, 1, 2, 3
            };
            // 4
            System.out.println(solution.subarraySum(nums, 3));
        }
    }

}
