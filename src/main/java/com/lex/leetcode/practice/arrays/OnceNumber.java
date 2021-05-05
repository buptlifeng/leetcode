package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 只出现1次的数字
 * 其他都出现2次
 * <p>
 * 简单
 *
 * @author lifeng
 */
public class OnceNumber {

    public int singleNumber(int[] nums) {
        int once = nums[0];
        for (int i = 1; i < nums.length; i++) {
            once ^= nums[i];
        }
        return once;
    }

    public static void main(String[] args) {
        OnceNumber solution = new OnceNumber();
        int[] nums = new int[]{
                2, 2, 1
        };
        System.out.println(solution.singleNumber(nums));

        nums = new int[]{
                4, 1, 2, 1, 2
        };
        System.out.println(solution.singleNumber(nums));
    }
}
