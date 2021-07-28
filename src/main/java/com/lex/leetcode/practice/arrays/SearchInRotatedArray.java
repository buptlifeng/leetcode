package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/27 下午10:02
 */
public class SearchInRotatedArray {

    public boolean search(int[] nums, int target) {
        // 1.找到旋转的轴
        int index = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
        }

        // 2.二分查找 index可能在开头或者结尾
        return binarySearch(nums, target, 0, index - 1)
                || binarySearch(nums, target, index, n - 1);
    }

    private boolean binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            if (left < 0 || right >= nums.length) {
                return false;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        {
            SearchInRotatedArray search = new SearchInRotatedArray();
            int[] nums = new int[]{
                    1, 0, 1, 1, 1
            };
            // true
            System.out.println(search.search(nums, 0));
        }

        {
            SearchInRotatedArray search = new SearchInRotatedArray();
            int[] nums = new int[]{
                    2, 5, 6, 0, 0, 1, 2
            };
            // true
            System.out.println(search.search(nums, 0));
        }

        {
            SearchInRotatedArray search = new SearchInRotatedArray();
            int[] nums = new int[]{
                    2, 5, 6, 0, 0, 1, 2
            };
            // false
            System.out.println(search.search(nums, 3));
        }

        {
            SearchInRotatedArray search = new SearchInRotatedArray();
            int[] nums = new int[]{
                    2, 2, 2, 2, 2, 2
            };
            // false
            System.out.println(search.search(nums, 3));
        }

        {
            SearchInRotatedArray search = new SearchInRotatedArray();
            int[] nums = new int[]{
                    1, 2, 3, 4, 5, 6
            };
            // true
            System.out.println(search.search(nums, 3));
        }
    }

}
