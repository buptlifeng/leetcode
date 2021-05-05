package com.lex.leetcode.practice.base;

/**
 * https://leetcode-cn.com/problems/binary-search/
 * 简单
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/29 下午10:24
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        {
            BinarySearch bs = new BinarySearch();
            int[] nums = new int[]{
                    -1, 0, 3, 5, 9, 12
            };
            // -1
            System.out.println(bs.search(nums, 13));

            // 4
            System.out.println(bs.search(nums, 9));

            // -1
            System.out.println(bs.search(nums, 2));

            // 0
            System.out.println(bs.search(nums, -1));

            // 5
            System.out.println(bs.search(nums, 12));
        }
    }

}
