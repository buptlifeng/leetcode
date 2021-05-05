package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 中等
 *
 * @author lifeng
 */
public class InsertIntoBST {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                } else {
                    cur = cur.left;
                }
            } else {
                if (val > cur.val) {
                    if (cur.right == null) {
                        cur.right = new TreeNode(val);
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        {
            InsertIntoBST solution = new InsertIntoBST();
            TreeNode root = new TreeNode(4);
            TreeNode r1 = new TreeNode(2);
            TreeNode r2 = new TreeNode(1);
            TreeNode r3 = new TreeNode(3);
            TreeNode r4 = new TreeNode(7);

            root.left = r1;
            root.right = r4;

            r1.left = r2;
            r1.right = r3;

            root = solution.insertIntoBST(root, 5);
            System.out.println(root);
        }
    }

}
