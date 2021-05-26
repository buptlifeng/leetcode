package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/25 下午10:28
 */
public class FindMin {

    /**
     * 典型的二分查找
     * 至少当前搜索的半个区间是有序的
     * 找到最小值即可
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            // 如果左半部分无序
            if (nums[l] > nums[mid]) {
                r = mid;
            } else if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        {
            FindMin fm = new FindMin();
            int[] nums = new int[]{
                    3, 4, 5, 1, 2
            };
            // 1
            System.out.println(fm.findMin(nums));
        }

        {
            FindMin fm = new FindMin();
            int[] nums = new int[]{
                    11, 13, 15, 17
            };
            // 11
            System.out.println(fm.findMin(nums));
        }

        {
            FindMin fm = new FindMin();
            int[] nums = new int[]{
                    4, 5, 6, 7, 0, 1, 2
            };
            // 0
            System.out.println(fm.findMin(nums));
        }
    }

}
