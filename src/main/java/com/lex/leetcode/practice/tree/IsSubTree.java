package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * 简单
 *
 * @author lifeng
 */
public class IsSubTree {

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


    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }

        return dfs(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {

        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }


    public static void main(String[] args) {
        {
            IsSubTree is = new IsSubTree();
            TreeNode s = new TreeNode(1);
            TreeNode t = new TreeNode(1);
            System.out.println(is.isSubtree(s, t));
        }
    }

}
