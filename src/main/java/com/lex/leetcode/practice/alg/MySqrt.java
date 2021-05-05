package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * 简单
 *
 * @author lifeng
 */
public class MySqrt {

    /**
     * 求二次方根
     * 返回数取整
     * 二分查找 [0,x]
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int ans = -1, l = 0, r = x;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            MySqrt ms = new MySqrt();
            System.out.println(ms.mySqrt(4));
            System.out.println(ms.mySqrt(8));
        }
    }

}
