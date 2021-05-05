package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 简单
 *
 * @author lifeng
 */
public class InvertTree {

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

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        invert(node.left);
        invert(node.right);
    }


    public static void main(String[] args) {

        {
            // [0,null,0,0,0]
            InvertTree pt = new InvertTree();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(2);
            TreeNode rrc = new TreeNode(3);

            root.right = rc;
            rc.right = rrc;

            // expect []
            System.out.println(pt.invertTree(root));
        }

        {
            InvertTree pt = new InvertTree();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(0);
            TreeNode lrc = new TreeNode(0);
            TreeNode rrc = new TreeNode(1);

            root.right = rc;
            rc.left = lrc;
            rc.right = rrc;

            System.out.println(pt.invertTree(root));
        }
    }

}
