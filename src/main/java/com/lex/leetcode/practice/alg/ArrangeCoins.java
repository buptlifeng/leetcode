package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/arranging-coins/
 * 简单
 *
 * @author lifeng
 */
public class ArrangeCoins {

    /**
     * 普通解法超时，需要改善算法
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int sum = 0, ret = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (sum <= n) {
                ret = i;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrangeCoins solution = new ArrangeCoins();
        System.out.println(solution.arrangeCoins(1));//1
        System.out.println(solution.arrangeCoins(2));//1
        System.out.println(solution.arrangeCoins(3));//2
        System.out.println(solution.arrangeCoins(4));//2
        System.out.println(solution.arrangeCoins(5));//2
        System.out.println(solution.arrangeCoins(6));//3
        System.out.println(solution.arrangeCoins(7));//3
        System.out.println(solution.arrangeCoins(8));//3
        System.out.println(solution.arrangeCoins(9));//3
        System.out.println(solution.arrangeCoins(10));//4
        System.out.println(solution.arrangeCoins(11));//4
        System.out.println(solution.arrangeCoins(15));//5
        System.out.println(solution.arrangeCoins(21));//6
    }

}
