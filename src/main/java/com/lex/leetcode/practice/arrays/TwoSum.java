package com.lex.leetcode.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 简单
 *
 * @author lifeng
 */
public class TwoSum {

    /**
     * 无序数组
     * 1.可以双重循环解决
     * 2.Hash 找到不存在的key
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{
                        map.get(target - nums[i]), i
                };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = new int[]{
                2, 7, 11, 15
        };
        int[] ret = solution.twoSum(nums, 9);
        System.out.println(ret);
    }

}
