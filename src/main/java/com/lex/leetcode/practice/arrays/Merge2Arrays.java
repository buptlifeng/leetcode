package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Merge2Arrays {

    /**
     * 思路
     * 1.合并2个数组后排序，效率最差
     * 2.申请一个新的数组，然后把元素合并到新数组里，空间：O(m+n)
     * 3.从数组最大元素开始合并，这样比从头开始合并优点在于：不用担心覆盖问题
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1, p2 = n - 1, p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }

        while (p2 >= 0) {
            nums1[p2] = nums2[p2];
            p2--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Merge2Arrays ma = new Merge2Arrays();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        ma.merge(nums1, 3, nums2, 3);
    }

}
