package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 * 简单
 *
 * @author lifeng
 */
public class IsUgly {

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] factor = new int[]{2, 3, 5};
        for (int f : factor) {
            while (num % f == 0) {
                num /= f;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        IsUgly iu = new IsUgly();
        System.out.println(iu.isUgly(5));
        System.out.println(iu.isUgly(8));
        System.out.println(iu.isUgly(14));
    }

}
