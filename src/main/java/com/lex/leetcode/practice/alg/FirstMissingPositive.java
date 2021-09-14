package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/first-missing-positive
 * 困难
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/9/5 下午8:05
 */
public class FirstMissingPositive {

    /**
     * 1.将负数转化为N+1
     * 2.遍历数组，如果当前元素为[0,N-1]区间的数，将数组相应下标对应的元素转化为负数，
     * 这样最终可将[0,N-1]内出现的元素全部标记出来；
     * 3.遍历元素，如果某个元素非负数，说明该下标没有出现过，应该是第一个丢失的正数；
     * 4.否则，第一个丢失的是N+1.
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        {
            FirstMissingPositive fmp = new FirstMissingPositive();
            int[] nums = new int[]{
                    1, 2, 0
            };
            // 3
            System.out.println(fmp.firstMissingPositive(nums));
        }

        {
            FirstMissingPositive fmp = new FirstMissingPositive();
            int[] nums = new int[]{
                    3, 4, -1, 1
            };
            // 2
            System.out.println(fmp.firstMissingPositive(nums));
        }

        {
            FirstMissingPositive fmp = new FirstMissingPositive();
            int[] nums = new int[]{
                    7, 8, 9, 11, 12
            };
            // 1
            System.out.println(fmp.firstMissingPositive(nums));
        }
    }
}
