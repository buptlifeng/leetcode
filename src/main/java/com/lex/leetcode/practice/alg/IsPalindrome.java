package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * 简单
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 简单
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/4/26 下午9:36
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        while (i <= j) {
            while (i < len && skipIllegal(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && skipIllegal(s.charAt(j))) {
                j--;
            }
            if (i >= len || j < 0) {
                break;
            }
            char lc = s.charAt(i), rc = s.charAt(j);
            if (toLower(lc) != toLower(rc)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private char toLower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch - 'A' + 'a');
        }
        return ch;
    }

    private boolean skipIllegal(char ch) {
        if (ch >= '0' && ch <= '9') {
            return false;
        }
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return false;
        }
        return true;
    }

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
        // true
        System.out.println(ip.isPalindrome("A man, a plan, a canal: Panama"));

        // true
        System.out.println(ip.isPalindrome("r  a  r"));

        // false
        System.out.println(ip.isPalindrome("race a car"));

        System.out.println(ip.isPalindrome(122));

        System.out.println(ip.isPalindrome(-121));

        System.out.println(ip.isPalindrome(121));

        System.out.println(ip.isPalindrome(1221));

        System.out.println(ip.isPalindrome(122));

        System.out.println(ip.isPalindrome(-121));
    }

}
