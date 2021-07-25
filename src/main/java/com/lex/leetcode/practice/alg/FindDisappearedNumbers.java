package com.lex.leetcode.practice.alg;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * 简单
 * 难点：不适用额外的空间，时间复杂度：O(n)
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/21 下午9:57
 */
public class FindDisappearedNumbers {

    /**
     * 普通方法1：放一个Set里，遍历set查看缺失元素
     * 普通方法2：排序之后，查找也是一种办法
     *
     * 进阶：构建一个环，检查环上哪个节点不存在
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        return null;
    }

    public static void main(String[] args) {
        {
            FindDisappearedNumbers solution = new FindDisappearedNumbers();
            int[] nums = new int[]{
                    4, 3, 2, 7, 8, 2, 3, 1
            };
            // 5,6
            solution.findDisappearedNumbers(nums);
        }

        {
            FindDisappearedNumbers solution = new FindDisappearedNumbers();
            int[] nums = new int[]{
                    1, 1
            };
            // 2
            solution.findDisappearedNumbers(nums);
        }
    }

}
