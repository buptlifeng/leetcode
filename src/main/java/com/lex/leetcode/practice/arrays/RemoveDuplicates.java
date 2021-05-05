package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 简单
 *
 * @author lifeng
 */
public class RemoveDuplicates {


    /**
     * 删除有序数组里的重复元素
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length, now = 1, pre = 0, cur = nums[0];
        while (now < len) {
            if (cur != nums[now]) {
                pre++;
                cur = nums[now];
                // 有间隔元素
                if (pre != now) {
                    nums[pre] = nums[now];
                }

            }
            now++;
        }
        return pre + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] nums = new int[]{
                1, 1, 2
        };
        System.out.println(solution.removeDuplicates(nums));
        // ,0,1,1,1,2,2,3,3,4

        nums = new int[]{
                0, 0, 1, 1, 1, 2, 2, 3, 3, 4
        };
        System.out.println(solution.removeDuplicates(nums));

        nums = new int[]{
                1, 1, 2, 2, 2, 3
        };
        System.out.println(solution.removeDuplicates(nums));

        nums = new int[]{
                1
        };
        System.out.println(solution.removeDuplicates(nums));
    }

}
