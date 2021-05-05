package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 简单
 *
 * @author lifeng
 */
public class Exchange {

    /**
     * 双指针，前后各找一个偶数和奇数之后开始交换即可
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            // 找到第一个偶数
            while (l < len && nums[l] % 2 != 0) {
                l++;
            }
            // 找到第一个奇数
            while (r >= 0 && nums[r] % 2 == 0) {
                r--;
            }
            // 奇偶交换
            if (l < r) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            }
        }
        return nums;
    }

    private static void print(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        {
            Exchange exchange = new Exchange();
            int[] nums = new int[]{
                    1, 2, 3, 4, 5
            };
            exchange.exchange(nums);
            // 1 5 3 2 4
            print(nums);
        }

        {
            Exchange exchange = new Exchange();
            int[] nums = new int[]{
                    1, 3, 5
            };
            exchange.exchange(nums);
            // 1 3 5
            print(nums);
        }

        {
            Exchange exchange = new Exchange();
            int[] nums = new int[]{
                    2, 4, 6
            };
            exchange.exchange(nums);
            // 2 4 6
            print(nums);
        }
    }

}
