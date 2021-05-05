package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 中等
 *
 * @author lifeng
 */
public class FindPeakElement {

    /**
     * 找到第一个峰值即可
     * 3种情况
     * 1.单向递增序列 nums[i] > nums[i+1]
     * 2.单向递减序列 nums[i] > nums[i+1]
     * 3.先增后减（峰值在中间）满足 nums[i] > nums[i+1]
     * 4.先减后增：这种情况回到第二种情况，第一个即峰值
     * <p>
     * 综上，都满足nums[i] > nums[i+1] 如果没有，返回最后一个元素即可
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        FindPeakElement solution = new FindPeakElement();
        int[] nums = new int[]{
                1, 2, 3, 4, 5
        };
        System.out.println(solution.findPeakElement(nums));

        nums = new int[]{
                5, 4, 3, 2, 1
        };
        System.out.println(solution.findPeakElement(nums));

        nums = new int[]{
                1, 2, 3, 2, 1
        };
        System.out.println(solution.findPeakElement(nums));
    }

}
