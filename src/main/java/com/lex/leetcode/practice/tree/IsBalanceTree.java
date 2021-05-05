package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 简单
 *
 * @author lifeng
 */
public class IsBalanceTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = dfs(root.left, 0);
        int rightDepth = dfs(root.right, 0);
        return Math.abs(leftDepth - rightDepth) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        int ld = dfs(node.left, depth + 1);
        int rd = dfs(node.right, depth + 1);
        return Math.max(ld, rd);
    }

    public static void main(String[] args) {

        {
            // [0,null,0,0,0]
            IsBalanceTree pt = new IsBalanceTree();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(2);
            TreeNode rrc = new TreeNode(3);

            root.right = rc;
            rc.right = rrc;

            // expect []
            System.out.println(pt.isBalanced(root));
        }

        {
            IsBalanceTree pt = new IsBalanceTree();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(0);
            TreeNode lrc = new TreeNode(0);
            TreeNode rrc = new TreeNode(1);

            root.right = rc;
            rc.left = lrc;
            rc.right = rrc;

            System.out.println(pt.isBalanced(root));
        }
    }

}
