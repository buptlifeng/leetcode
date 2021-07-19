package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 困难
 * TODO
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/6/23 下午9:35
 */
public class FindMinII {

    /**
     * 可能存在重复元素
     * 当左 中 右都一样时，指针如何处理？
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int mv = nums[mid];
            if(mv >= nums[l]){

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        {
            FindMinII fm = new FindMinII();
            int[] nums = new int[]{
                    1, 2, 3
            };
            System.out.println(fm.findMin(nums));
        }
    }

}
