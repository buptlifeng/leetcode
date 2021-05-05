package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 * 中等
 *
 * @author lifeng
 */
public class PruneTree {

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
     * 递归，先查看左子树，进行剪枝，然后查看右子树，进行剪枝
     * 如果为空，不再进行递归
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        TreeNode nr = dfs(root);
        if(nr == null ||
                (nr.val == 0 && (nr.left == null && nr.right == null))
        ){
            return null;
        }
        return nr;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = dfs(node.left);
        // 左子树剪枝
        if (left != null
                && (!(left.left != null || left.right != null))
                && left.val == 0) {
            node.left = null;
        }

        TreeNode right = dfs(node.right);
        // 右子树剪枝
        if (right != null
                && (!(right.left != null || right.right != null))
                && right.val == 0) {
            node.right = null;
        }

        return node;
    }

    public static void main(String[] args) {

        {
            // [0,null,0,0,0]
            PruneTree pt = new PruneTree();
            TreeNode root = new TreeNode(0);
            TreeNode rc = new TreeNode(0);
            TreeNode lrc = new TreeNode(0);
            TreeNode rrc = new TreeNode(0);

            root.right = rc;
            rc.left = lrc;
            rc.right = rrc;

            TreeNode ret = pt.pruneTree(root);
            // expect []
            System.out.println(ret);
        }

        {
            PruneTree pt = new PruneTree();
            TreeNode root = new TreeNode(1);
            TreeNode rc = new TreeNode(0);
            TreeNode lrc = new TreeNode(0);
            TreeNode rrc = new TreeNode(1);

            root.right = rc;
            rc.left = lrc;
            rc.right = rrc;

            TreeNode ret = pt.pruneTree(root);
            System.out.println(ret);
        }
    }

}
