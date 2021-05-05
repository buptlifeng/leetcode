package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 中等
 * <p>
 * 这题的难度比预计的要高
 *
 * @author lifeng
 */
public class MinSubArrayLen {

    /**
     * O(n)的时间复杂度
     * 滑动窗口
     * 在本题中实现滑动窗口，主要确定如下三点：
     *
     * 窗口内是什么？
     * 如何移动窗口的起始位置？
     * 如何移动窗口的结束位置？
     * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
     *
     * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
     *
     * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLenOn(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, sum = 0, ans = n + 1;
        while (r < n) {
            sum += nums[r];
            // 窗口精髓
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return ans == (n + 1) ? 0 : ans;
    }

    /**
     * O(nLogn)的时间复杂度
     * 采用二分法
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLenOnLogN(int target, int[] nums) {

        return 0;
    }

    public static void main(String[] args) {
        {
            MinSubArrayLen solution = new MinSubArrayLen();
            int[] nums = new int[]{
                    2, 3, 1, 2, 4, 3
            };
            System.out.println(solution.minSubArrayLenOn(7, nums));
        }

        {
            MinSubArrayLen solution = new MinSubArrayLen();
            int[] nums = new int[]{
                    1, 4, 4
            };
            System.out.println(solution.minSubArrayLenOn(4, nums));
        }

        {
            MinSubArrayLen solution = new MinSubArrayLen();
            int[] nums = new int[]{
                    1, 1, 1, 1, 1, 1, 1, 1
            };
            System.out.println(solution.minSubArrayLenOn(11, nums));
        }
    }

}
