package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * 中等
 *
 * @author lifeng
 */
public class NthUglyNumberII {

    /**
     * 只包含2，3，5作为质因数的数
     * <p>
     * 使用dp，i2,i3,i5分别代表2，3，5应该乘的因子，都从0开始
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] nums = new int[1690];
        nums[0] = 1;
        for (int i = 1; i < 1690; i++) {
            int next = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
            nums[i] = next;
            if (next == nums[i2] * 2) {
                i2++;
            }
            if (next == nums[i3] * 3) {
                i3++;
            }
            if (next == nums[i5] * 5) {
                i5++;
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12
        NthUglyNumberII solution = new NthUglyNumberII();
        // 1
        System.out.println(solution.nthUglyNumber(1));
        // 4
        System.out.println(solution.nthUglyNumber(4));
        // 12
        System.out.println(solution.nthUglyNumber(10));
    }

}
