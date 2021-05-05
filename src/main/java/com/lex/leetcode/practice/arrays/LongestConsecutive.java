package com.lex.leetcode.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 困难
 *
 * @author lifeng
 */
public class LongestConsecutive {

    /**
     * 未排序数组
     * 查找连续的元素（元素不要求连续）
     * tips:使用set保存所有元素，这样可以快速判断某个元素是否存在
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }

        for (int n : nums) {
            // 仅考虑从当前元素往后存在的连续序列
            if (!numSet.contains(n - 1)) {
                int cur = n;
                int count = 1;
                while (numSet.contains(cur + 1)) {
                    cur++;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            LongestConsecutive solution = new LongestConsecutive();
            int[] nums = new int[]{100, 4, 200, 1, 3, 2};
            // 4
            System.out.println(solution.longestConsecutive(nums));
        }

        {
            LongestConsecutive solution = new LongestConsecutive();
            int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
            // 9
            System.out.println(solution.longestConsecutive(nums));
        }
    }

}
