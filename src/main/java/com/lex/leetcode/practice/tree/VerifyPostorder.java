package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/6/22 下午9:50
 */
public class VerifyPostorder {

    /**
     * 一次直接AC
     * 超过100%
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int is = start, root = postorder[end];
        // 全部小于root
        while (is < end && postorder[is] < root) {
            is++;
        }

        // 记录左子树最右边界
        int leftEnd = is - 1;

        // 必须全部大于root
        while (is < end) {
            if (postorder[is] < root) {
                return false;
            }
            is++;
        }

        return verify(postorder, start, leftEnd) && verify(postorder, leftEnd + 1, end - 1);
    }

    public static void main(String[] args) {
        {
            VerifyPostorder vp = new VerifyPostorder();
            int[] arr = new int[]{
                    1, 6, 3, 2, 5
            };
            // false
            System.out.println(vp.verifyPostorder(arr));
        }

        {
            VerifyPostorder vp = new VerifyPostorder();
            int[] arr = new int[]{
                    1, 3, 2, 6, 5
            };
            // true
            System.out.println(vp.verifyPostorder(arr));
        }
    }

}
