package com.lex.leetcode.practice.alg;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 中等
 *
 * @author lifeng
 */
public class Rand10 {

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }

    /**
     * (rand7 - 1) * 7 + rand7
     * 等概率生成1-49的数字，但是我们只需要使用1-40，因此，如果生成了[41,49]需要重选
     * @return
     */
    public int rand10() {
        int row, col, idx;
        do {
            col = rand7();
            row = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    public static void main(String[] args) {
        Rand10 r10 = new Rand10();
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
        System.out.println(r10.rand10());
    }

}
