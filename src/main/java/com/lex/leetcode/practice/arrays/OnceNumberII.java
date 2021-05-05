package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * 只出现1次的数字
 * 其他都出现3次
 * <p>
 * 中等
 *
 * @author lifeng
 */
public class OnceNumberII {

    /**
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int once = 0, twice = 0;
        for (int no : nums) {
            once = ~twice & (once ^ no);
            twice = ~once & (twice ^ no);
        }
        return once;
    }

    public static void main(String[] args) {
        OnceNumberII solution = new OnceNumberII();
        int[] nums = new int[]{
                2, 2, 3, 2
        };
        System.out.println(solution.singleNumber(nums));

        nums = new int[]{
                0, 1, 0, 1, 0, 1, 99
        };
        System.out.println(solution.singleNumber(nums));
    }
}
