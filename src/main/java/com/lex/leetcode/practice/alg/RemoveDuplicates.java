package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/22 下午9:23
 */
public class RemoveDuplicates {

    /**
     * 注意：数组是有序的
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int p1 = 2, p2 = 2;
        while (p2 < n) {
            if (nums[p1 - 2] != nums[p2]) {
                nums[p1] = nums[p2];
                p1++;
            }
            p2++;
        }
        return p1;
    }

    public static void main(String[] args) {
        {
            RemoveDuplicates rd = new RemoveDuplicates();
            int[] nums = new int[]{
                    0, 0, 1, 1, 1, 1, 2, 3, 3
            };
            // 7, nums = [0,0,1,1,2,3,3]
            System.out.println(rd.removeDuplicates(nums));
        }

        {
            RemoveDuplicates rd = new RemoveDuplicates();
            int[] nums = new int[]{
                    1, 1, 1, 2, 2, 3
            };
            // 5, nums = [1,1,2,2,3]
            System.out.println(rd.removeDuplicates(nums));
        }
    }

}
