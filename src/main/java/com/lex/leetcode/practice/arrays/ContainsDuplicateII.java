package com.lex.leetcode.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * 简单
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // 大小超过k，移除当前放入最早的元素
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII solution = new ContainsDuplicateII();
        {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println(solution.containsNearbyDuplicate(nums, 3));
        }

        {
            int[] nums = new int[]{1, 0, 1, 1};
            System.out.println(solution.containsNearbyDuplicate(nums, 1));
        }

        {
            int[] nums = new int[]{1, 2, 3, 1, 2, 3};
            System.out.println(solution.containsNearbyDuplicate(nums, 2));
        }
    }

}
