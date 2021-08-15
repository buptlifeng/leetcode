package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 简单
 *
 * @author lifeng
 */
public class DiameterOfBinaryTree {

    static class TreeNode {
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
     * 求任意2个节点的最大距离
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    int ans;

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ld = dfs(node.left);
        int rd = dfs(node.right);
        ans = Math.max(ans, ld + rd + 1);
        return Math.max(ld, rd) + 1;
    }

    public static void main(String[] args) {
        {
            DiameterOfBinaryTree pot = new DiameterOfBinaryTree();

            TreeNode root = new TreeNode(1);
            TreeNode rl = new TreeNode(2);
            TreeNode rr = new TreeNode(3);
            root.left = rl;
            root.right = rr;

            TreeNode rll = new TreeNode(4);
            TreeNode rlr = new TreeNode(5);
            rl.left = rll;
            rl.right = rlr;

            System.out.println(pot.diameterOfBinaryTree(root));
        }
    }

}
