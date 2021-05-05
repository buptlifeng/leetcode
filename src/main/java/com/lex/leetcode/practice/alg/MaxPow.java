package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/powx-n
 * 中等
 * <p>
 * 1.输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * <p>
 * 2.输入：x = 2.10000, n = 3
 * 输出：9.26100
 * <p>
 * 3.输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 */
public class MaxPow {

    /**
     * 快速幂+递归
     * x^6 = x * x^2
     *
     * @param x
     * @param n
     * @return
     */
    public double myPowRecursion(double x, int n) {
        long N = n;
        return n >= 0 ? quickMul1(x, N) : 1.0 / quickMul1(x, -N);
    }

    private double quickMul1(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double ret = quickMul1(x, n / 2);
        return n % 2 == 0 ? ret * ret : x * ret * ret;
    }

    public double myPowIterator(double x, int n) {
        long N = n;
        return n >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

    private double quickMul2(double x, long n) {
        double ret = 1.0;
        double bitBase = x;
        while (n > 0) {
            // 该位为1，说明需要加上该位的值
            if (n % 2 == 1) {
                ret *= bitBase;
            }
            bitBase *= bitBase;
            n /= 2;
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxPow solution = new MaxPow();
        System.out.println(solution.myPowRecursion(2.0, 10));

        System.out.println(solution.myPowRecursion(2.10000, 3));

        System.out.println(solution.myPowRecursion(2.0, -2));

        System.out.println(solution.myPowIterator(2.0, 10));

        System.out.println(solution.myPowIterator(2.10000, 3));

        System.out.println(solution.myPowIterator(2.0, -2));

    }

}
