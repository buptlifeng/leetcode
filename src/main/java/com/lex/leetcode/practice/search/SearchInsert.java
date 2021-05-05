package com.lex.leetcode.practice.search;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * <p>
 * 简单
 * <p>
 * 二分查找
 *
 * @author lifeng
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, pos = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                pos = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        SearchInsert solution = new SearchInsert();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 1));
        System.out.println(solution.searchInsert(nums, 3));
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 6));
        System.out.println(solution.searchInsert(nums, 0));
        System.out.println(solution.searchInsert(nums, 7));
    }

}
