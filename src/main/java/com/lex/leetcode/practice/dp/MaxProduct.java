package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 中等
 *
 * @author lifeng
 */
public class MaxProduct {

    /**
     * 因为数字可能为负数，所以，转移方程如下：
     * 使用2个数组，一个记录最大值，一个记录最小值，分别是：fmax,fmin
     * fmax[i] = max{fmax[i-1]*nums[i],fmin[i-1]*nums[i]}
     * fmin[i] = min{fmax[i-1]*nums[i],fmin[i-1]*nums[i]}
     * <p>
     * 这样可以保证每次得到最大值
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fmax = new int[n];
        int[] fmin = new int[n];

        fmax[0] = nums[0];
        fmin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            fmax[i] = Math.max(fmax[i - 1] * nums[i], Math.max(fmin[i - 1] * nums[i], nums[i]));
            fmin[i] = Math.min(fmax[i - 1] * nums[i], Math.min(fmax[i - 1] * nums[i], nums[i]));
        }

        int ans = fmax[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, fmax[i]);
        }
        return ans;
    }

    public int maxProductLessSpace(int[] nums) {
        int n = nums.length;
        int fmax = nums[0], fmin = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            int min = fmin, max = fmax;
            fmax = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            fmin = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
            ans = Math.max(ans, fmax);
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            MaxProduct mp = new MaxProduct();
            int[] nums = new int[]{
                    2, 3, -2, 4
            };
            // 6
            System.out.println(mp.maxProduct(nums));
            System.out.println(mp.maxProductLessSpace(nums));
        }

        {
            MaxProduct mp = new MaxProduct();
            int[] nums = new int[]{
                    -2, 0, -1
            };
            // 0
            System.out.println(mp.maxProduct(nums));
            System.out.println(mp.maxProductLessSpace(nums));
        }
    }

}
