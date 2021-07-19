package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 * 中等
 *
 * 如果有多个答案，保证至少返回一个
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/19 下午10:08
 */
public class ConstructFromPrePost {
    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        return null;
    }

}
