package com.lex.leetcode.practice.solutions;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-strings/
 * 简单
 *
 * @author lifeng
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        // 注意进位，还有处理最后的进位
        int digit = 0, i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int n2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
            int result = n1 + n2 + digit;
            digit = result / 10;
            sb.append(result % 10);
            i--;
            j--;
        }

        if (digit > 0) {
            sb.append(digit);
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        {
            AddStrings solution = new AddStrings();
            System.out.println(solution.addStrings("1", "2"));

            System.out.println(solution.addStrings("1", "9"));

            System.out.println(solution.addStrings("999", "1111"));

        }
    }

}
