package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 */
public class ClimbStairs {

    /**
     * 空间：O(n)
     * 时间：O(n)
     *
     * @param n
     * @return
     */
    public int climbStairsWithSpace(int n) {
        if (n < 3) {
            return n;
        }
        int[] ans = new int[n];
        ans[0] = 1;
        ans[1] = 2;
        for (int i = 2; i < n; i++) {
            ans[i] = ans[i - 1] + ans[i - 2];
        }
        return ans[n - 1];
    }

    /**
     * 上一种写法的优化，只使用2个变量即可
     *
     * @param n
     * @return
     */
    public int climbStairsConst(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1, second = 2;
        for (int i = 2; i < n; i++) {
            // 更新到达n阶的方案总数
            int steps = first + second;
            // 更新到达前2步的写法
            first = second;
            second = steps;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();

        System.out.println(cs.climbStairsConst(3));
        System.out.println(cs.climbStairsWithSpace(3));

        System.out.println(cs.climbStairsConst(5));
        System.out.println(cs.climbStairsWithSpace(5));
    }

}
