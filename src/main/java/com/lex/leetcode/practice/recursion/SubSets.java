package com.lex.leetcode.practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 中等
 *
 * @author lifeng
 */
public class SubSets {


    /**
     * 相当于一个n位数，每个数均是可选和不可选
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithIteration(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int n = nums.length;
        // 遍历2^n个可能性
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            // 遍历每一位，如果该位为1，则表示选中了原数组中的该数
            for (int k = 0; k < n; k++) {
                if ((mask & (1 << k)) != 0) {
                    t.add(nums[k]);
                }
            }
            ans.add(t);
        }
        return ans;
    }


    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        subRecursion(nums, 0);
        return ans;
    }

    private void subRecursion(int[] nums, int cur) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        // 选择cur个元素
        t.add(nums[cur]);
        subRecursion(nums, cur + 1);
        // 不选择cur个元素=移除最后一个元素
        t.remove(t.size() - 1);
        subRecursion(nums, cur + 1);
    }

    public static void main(String[] args) {
        {
            SubSets solution = new SubSets();
            int[] nums = new int[]{
                    1,2,3,4
            };
            System.out.println(solution.subsets(nums));
        }
    }

}
