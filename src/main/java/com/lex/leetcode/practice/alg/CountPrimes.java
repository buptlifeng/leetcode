package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/count-primes
 * 简单
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/24 下午9:55
 */
public class CountPrimes {

    /**
     * <n 的非负整数的质数
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    private boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(5));

        // 4
        System.out.println(cp.countPrimes(10));
    }

}
