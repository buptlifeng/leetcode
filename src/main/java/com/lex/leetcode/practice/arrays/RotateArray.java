package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * 中等
 * <p>
 * 至少3种解决方案
 *
 * @author lifeng
 */
public class RotateArray {

    /**
     * 使用翻转法
     * 1.整体翻转
     * 2.(0,k/mod n) 翻转
     * 3.(k/mod n, n) 翻转
     *
     * @param nums
     * @param k
     */
    public void rotateWithReverse(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 最好使用原地变换 O(1)空间
     * <p>
     * 1.下标变换是有规律的
     * 2.利用变换次数，控制退出循环
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        int len = nums.length, n = len, cur = 0, preVal = nums[cur];
        // 使用n次是不对的，需要求最大公约数
        while (n > 0) {
            int next = (k + cur) % len;
            int temp = nums[next];
            nums[next] = preVal;
            preVal = temp;
            cur = next;
            n--;
        }
    }

    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        /*int[] nums1 = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        solution.rotate(nums1, 3);
        System.out.println(nums1);*/

        int[] nums2 = new int[]{
                -1, -100, 3, 99
        };
        solution.rotate(nums2, 2);
        System.out.println(nums2);
    }
}
