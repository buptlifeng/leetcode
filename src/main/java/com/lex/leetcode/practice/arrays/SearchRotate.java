package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 中等
 *
 * @author lifeng
 */
public class SearchRotate {

    /**
     * O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchN(int[] nums, int target) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return ans;
    }


    /**
     * 类似的问题是否考虑二分法？
     * O(logN)
     * <p>
     * 1.mid 落在左边或者右边数组，mid为中间值，正常二分
     * 2.mid 落在左边，mid为最大值
     * 3.mid 落在右边，mid为最小值
     * <p>
     * 简化：
     * mid左右一侧，至少有一个是有序的，然后判断target应该在有序区间内or另外一侧;
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchLogN(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int mv = nums[mid];
            if (mv == target) {
                return mid;
            }

            if (mv >= nums[l]) {
                if (target >= nums[l] && target < mv) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > mv && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        {
            SearchRotate solution = new SearchRotate();
            int[] nums = new int[]{
                    3, 5, 1
            };
            // 0
            System.out.println(solution.searchN(nums, 3));
            System.out.println(solution.searchLogN(nums, 3));
        }

        {
            SearchRotate solution = new SearchRotate();
            int[] nums = new int[]{
                    3, 1
            };
            // 1
            System.out.println(solution.searchN(nums, 1));
            System.out.println(solution.searchLogN(nums, 1));
        }

        {
            SearchRotate solution = new SearchRotate();
            int[] nums = new int[]{
                    4, 5, 6, 7, 0, 1, 2
            };
            // 4
            System.out.println(solution.searchN(nums, 0));
            System.out.println(solution.searchLogN(nums, 0));
        }

        {
            SearchRotate solution = new SearchRotate();
            int[] nums = new int[]{
                    4, 5, 6, 7, 0, 1, 2
            };
            // -1
            System.out.println(solution.searchN(nums, 3));
            System.out.println(solution.searchLogN(nums, 3));
        }

        {
            SearchRotate solution = new SearchRotate();
            int[] nums = new int[]{
                    1
            };
            // -1
            System.out.println(solution.searchN(nums, 0));
            System.out.println(solution.searchLogN(nums, 0));
        }
    }

}
