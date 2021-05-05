package com.lex.leetcode.practice.search;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 中等
 *
 * @author lifeng
 */
public class SearchRange {

    /**
     * 要求：
     * 时间：O(logn) 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int li = -1, ri = -1;
        if (nums == null) {
            return new int[]{li, ri};
        }
        li = binarySearch(nums, target, true);
        ri = binarySearch(nums, target, false);
        return new int[]{li, ri};
    }

    int binarySearch(int[] nums, int target, boolean direLeft) {
        int l = 0, r = nums.length - 1, m = -1;
        while (l <= r) {
            int md = (l + r) / 2;
            if (nums[md] == target) {
                m = md;
                // 主要在于找到target之后的处理，如果找左边界，继续往左；
                // 如果找有边界，继续往右
                if (direLeft) {
                    r = md - 1;
                } else {
                    l = md + 1;
                }
            } else if (nums[md] > target) {
                r = md - 1;
            } else {
                l = md + 1;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        {
            SearchRange solution = new SearchRange();
            int[] nums = new int[]{1};
            int[] ans1 = solution.searchRange(nums, 1);
            // 0 0
            System.out.println(ans1[0] + " " + ans1[1]);
        }

        {
            SearchRange solution = new SearchRange();
            int[] nums = new int[]{
                    5, 7, 7, 8, 8, 10
            };
            int[] ans1 = solution.searchRange(nums, 8);
            // 3 4
            System.out.println(ans1[0] + " " + ans1[1]);

            int[] ans2 = solution.searchRange(nums, 6);
            // -1 -1
            System.out.println(ans2[0] + " " + ans2[1]);

            int[] ans3 = solution.searchRange(nums, 5);
            // 0 0
            System.out.println(ans3[0] + " " + ans3[1]);

            int[] ans4 = solution.searchRange(nums, 10);
            // 5 5
            System.out.println(ans4[0] + " " + ans4[1]);

            int[] ans5 = solution.searchRange(nums, 11);
            // -1 -1
            System.out.println(ans5[0] + " " + ans5[1]);
        }

        {
            SearchRange solution = new SearchRange();
            int[] nums = new int[]{};
            int[] ans1 = solution.searchRange(nums, 0);
            // -1 -1
            System.out.println(ans1[0] + " " + ans1[1]);
        }
    }
}
