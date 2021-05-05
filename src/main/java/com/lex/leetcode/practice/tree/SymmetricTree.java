package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 简单
 * 验证是否为镜像对称二叉树
 *
 * @author lifeng
 */
public class SymmetricTree {

    public class TreeNode {
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

    /**
     * 递归法
     *
     * @param root
     * @return
     */
    public boolean isSymmetricRecursion(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

}
