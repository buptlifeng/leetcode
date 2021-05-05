package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 简单
 * <p>
 * 正常情况下是从左向右复制，但这样面临元素覆盖的问题（合并至num1数组），
 * 如果换个方向，从右向左，长度为m+n，考虑以下3种情况
 * 1.nums1里最大元素小于nums2，从右向左，复制的前n个元素都是nums2的，不影响nums1的元素;
 * 2.nums2里最大元素小于nums1，从右向左，复制的前m个元素都是nums1的，只是原地迁移了nums1的元素，不影响nums2的元素;
 * 3.如果元素是交叉的，复制对应的元素至指定位置，分别记录：右侧边界，nums1边界，nums2边界，也不存在覆盖的问题；
 */
public class Merge2SortedArrays {

    /**
     * 要求：将数组合并至nums1
     * 从右向左开始复制
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1, r2 = n - 1, r = m + n - 1;
        while (r1 >= 0 && r2 >= 0) {
            if (nums1[r1] > nums2[r2]) {
                nums1[r--] = nums1[r1--];
            } else {
                nums1[r--] = nums2[r2--];
            }
        }
        while (r1 >= 0) {
            nums1[r--] = nums1[r1--];
        }

        while (r2 >= 0) {
            nums1[r--] = nums2[r2--];
        }
    }

    public static void main(String[] args) {
        Merge2SortedArrays solution = new Merge2SortedArrays();
        int[] nums1 = new int[]{
                1, 2, 3, 0, 0
        };
        int[] nums2 = new int[]{
                4, 5
        };
        solution.merge(nums1, 3, nums2, 2);

        int[] nums3 = new int[]{1};
        int[] nums4 = new int[]{};
        solution.merge(nums3, 1, nums4, 0);

        int[] nums5 = new int[]{0};
        int[] nums6 = new int[]{1};
        solution.merge(nums5, 0, nums6, 1);

        System.out.println();
    }

}
