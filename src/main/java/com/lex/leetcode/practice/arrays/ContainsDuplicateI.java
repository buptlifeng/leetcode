package com.lex.leetcode.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * 简单
 */
public class ContainsDuplicateI {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateI solution = new ContainsDuplicateI();
        {
            int[] nums = new int[]{1, 2, 3, 1};
            System.out.println(solution.containsDuplicate(nums));
        }

        {
            int[] nums = new int[]{1, 2, 3, 4};
            System.out.println(solution.containsDuplicate(nums));
        }

        {
            int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
            System.out.println(solution.containsDuplicate(nums));
        }
    }

}
