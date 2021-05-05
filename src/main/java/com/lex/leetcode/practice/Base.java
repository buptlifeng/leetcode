package com.lex.leetcode.practice;

public class Base {

    public void printArray(char[][] array) {

        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array[0].length; k++) {
                System.out.print(array[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
