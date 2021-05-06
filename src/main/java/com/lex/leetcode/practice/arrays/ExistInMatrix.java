package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 中等
 *
 * TODO
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/5 下午3:40
 */
public class ExistInMatrix {

    public boolean exist(char[][] board, String word) {

        return false;
    }

    public static void main(String[] args) {
        {
            ExistInMatrix solution = new ExistInMatrix();
            char[][] board = new char[][]{
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };
            // true
            System.out.println(solution.exist(board, "ABCCED"));
        }

        {
            ExistInMatrix solution = new ExistInMatrix();
            char[][] board = new char[][]{
                    {'a', 'b'},
                    {'c', 'd'}
            };
            // false
            System.out.println(solution.exist(board, "abcd"));
        }
    }

}
