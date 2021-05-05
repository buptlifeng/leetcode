package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/30 下午8:35
 */
public class ProductExceptSelf {

    public int[] productExceptSelfDp(int[] nums) {
        int n = nums.length;
        int[] ldp = new int[n];
        int[] rdp = new int[n];
        ldp[0] = 1;
        rdp[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            ldp[i] = ldp[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i > -1; i--) {
            rdp[i] = rdp[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = ldp[i] * rdp[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            ProductExceptSelf pes = new ProductExceptSelf();
            int[] nums = new int[]{
                    1, 2, 3, 4
            };
            int[] ans = pes.productExceptSelfDp(nums);
            for (int n : ans) {
                System.out.print("n=" + n + " ");
            }
        }
    }

}
