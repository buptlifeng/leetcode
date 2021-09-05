package com.lex.leetcode.practice.alg;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/8/22 下午5:05
 */
public class ThreeSumClosest {

    /**
     * 最接近目标值得的3个数之和
     * 排序+双指针
     * 因为排序后有序，所以：
     * a,b,c
     * sum = a+b+c > target时，必须c左移，否则移动b，只会使得sum增大
     * sum = a+b+c < target时，必须b右移，否则移动c，只会使得sum减小
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int ans = 10000000, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    // 小优化，找到左侧第一个不相等的元素
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        k0--;
                    }
                    k = k0;
                } else {
                    int j1 = j + 1;
                    while (j1 < k && nums[j1] == nums[j]) {
                        j1++;
                    }
                    j = j1;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            ThreeSumClosest tsc = new ThreeSumClosest();
            int[] nums = new int[]{
                    -1, 2, 1, -4
            };
            // 2
            System.out.println(tsc.threeSumClosest(nums, 1));
        }
    }

}
