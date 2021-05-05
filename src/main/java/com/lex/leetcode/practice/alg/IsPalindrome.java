package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 简单
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/26 下午9:36
 */
public class IsPalindrome {

    /**
     * 判断是否回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int[] bitArray = new int[31];
        int q = x, index = 0;
        while (q > 0) {
            bitArray[index++] = q % 10;
            q /= 10;
        }

        int l = 0, r = index - 1;
        while (l <= r) {
            if (bitArray[l] == bitArray[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome(121));

        System.out.println(ip.isPalindrome(1221));

        System.out.println(ip.isPalindrome(122));

        System.out.println(ip.isPalindrome(-121));
    }

}
