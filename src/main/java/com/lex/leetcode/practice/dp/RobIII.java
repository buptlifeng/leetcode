package com.lex.leetcode.practice.dp;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 中等
 *
 * @author lifeng
 */
public class RobIII {

    class TreeNode {
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
     * f(o)为选择o节点的最大值，g(o)为不选择o节点的最大值，左右子节点分别为：l,r
     * 1.选中o：f(o) = g(l) + g(r)
     * 2.不选中o(2个子节点也可以分别为选中和不选)：g(o) = max{g(l),f(l)} + max{g(r),f(r)}
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(fm.getOrDefault(root, 0), gm.getOrDefault(root, 0));
    }

    Map<TreeNode, Integer> fm = new HashMap<>();
    Map<TreeNode, Integer> gm = new HashMap<>();

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        dfs(node.right);
        int fv = node.val + gm.getOrDefault(node.left, 0) + gm.getOrDefault(node.right, 0);
        fm.put(node, fv);

        int gv = Math.max(gm.getOrDefault(node.left, 0), fm.getOrDefault(node.left, 0))
                + Math.max(gm.getOrDefault(node.right, 0), fm.getOrDefault(node.right, 0));
        gm.put(node, gv);
    }

    public int robLessMem(TreeNode root) {
        int[] ans = dfsLessMem(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] dfsLessMem(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] ldfs = dfsLessMem(node.left);
        int[] rdfs = dfsLessMem(node.right);
        int select = node.val + ldfs[1] + rdfs[1];
        int notSelect = Math.max(ldfs[0], ldfs[1]) + Math.max(rdfs[0], rdfs[1]);
        return new int[]{select, notSelect};
    }
}
