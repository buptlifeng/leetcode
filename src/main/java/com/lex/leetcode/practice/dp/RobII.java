package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 中等
 * <p>
 * 区别在于首尾元素被认为是一个环(相邻)
 *
 * @author lifeng
 */
public class RobII {

    /**
     * 还是dp，但是要加一个限制，首尾元素需要特殊处理
     * 可以分别求[0,n-2]和[1,n-1] 两种情况下的最大值，然后比较，取大值即可
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
        int m1 = myRob(nums, 0, len - 2);
        int m2 = myRob(nums, 1, len - 1);
        return Math.max(m1, m2);
    }

    private int myRob(int[] nums, int start, int end) {
        int first = 0, second = 0;
        for (int i = start; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        {
            RobII solution = new RobII();
            int[] nums = new int[]{
                    1, 2, 3, 1
            };
            System.out.println(solution.rob(nums));
        }

        {
            RobII solution = new RobII();
            int[] nums = new int[]{
                    2, 3, 2
            };
            System.out.println(solution.rob(nums));
        }
    }


}
