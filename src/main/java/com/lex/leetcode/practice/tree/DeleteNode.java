package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 中等
 *
 * @author lifeng
 */
public class DeleteNode {

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

    /**
     * 删除节点
     * 1.如果节点没有子节点，直接删除；
     * 2.如果其中一个子节点没有孩子节点，可直接删除；
     * 3.如果待删除节点的子节点左右子树都不为空，需要讨论：
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                // 删除后继节点
                root.right = deleteNode(root.right, root.val);
            } else {
                root.val = predecessor(root);
                // 删除前驱节点
                root.left = deleteNode(root.left, root.val);
            }

        }
        return root;
    }

    private int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public static void main(String[] args) {

        {
            // [0,null,0,0,0]
            DeleteNode pt = new DeleteNode();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(2);
            TreeNode rrc = new TreeNode(3);

            root.right = rc;
            rc.right = rrc;

            // expect []
            System.out.println(pt.deleteNode(root, 2));
        }

        {
            DeleteNode pt = new DeleteNode();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(0);
            TreeNode lrc = new TreeNode(0);
            TreeNode rrc = new TreeNode(1);

            root.right = rc;
            rc.left = lrc;
            rc.right = rrc;

            System.out.println(pt.deleteNode(root, 3));
        }
    }

}
