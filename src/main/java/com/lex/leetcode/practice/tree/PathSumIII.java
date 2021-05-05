package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 * 中等
 *
 * @author lifeng
 */
public class PathSumIII {

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
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root, sum, 0)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int pathSum(TreeNode node, int sum, int curSum) {
        if (node == null) {
            return 0;
        }
        int total = curSum + node.val == sum ? 1 : 0;

        // 根节点继续往下找
        int ls = pathSum(node.left, sum, curSum + node.val);
        int rs = pathSum(node.right, sum, curSum + node.val);
        total += (ls + rs);

        return total;
    }

    public static void main(String[] args) {
        {
            PathSumIII ps = new PathSumIII();

            TreeNode root = new TreeNode(10);
            TreeNode l1 = new TreeNode(5);
            TreeNode r1 = new TreeNode(-3);
            root.left = l1;
            root.right = r1;

            TreeNode l1l = new TreeNode(3);
            TreeNode l1r = new TreeNode(2);
            l1.left = l1l;
            l1.right = l1r;

            TreeNode l1ll = new TreeNode(3);
            TreeNode l1lr = new TreeNode(-2);
            l1l.left = l1ll;
            l1l.right = l1lr;

            l1r.right = new TreeNode(1);

            r1.right = new TreeNode(11);
            System.out.println(ps.pathSum(root, 8));
        }
    }

}
