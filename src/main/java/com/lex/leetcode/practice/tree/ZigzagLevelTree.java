package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * 中等
 * 按层次锯齿形遍历
 *
 * @author lifeng
 */
public class ZigzagLevelTree {

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

    /**
     * 层次遍历
     * 从左到右，然后从右到左，交替进行
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        boolean directRight = true;
        while (levelNodes.size() > 0) {
            // 维护节点永远从左到右
            List<TreeNode> curLevelNodes = new ArrayList<>();
            // 需要根据当前遍历方向来决定
            List<Integer> curVals = new ArrayList<>();
            for (TreeNode node : levelNodes) {
                curVals.add(node.val);
                if (node.left != null) {
                    curLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    curLevelNodes.add(node.right);
                }
            }

            if (directRight) {
                ret.add(curVals);
            } else {
                // 逆序
                ret.add(reverse(curVals));
            }

            directRight = !directRight;
            levelNodes = curLevelNodes;
        }

        return ret;
    }

    private List<Integer> reverse(List<Integer> curVals) {
        List<Integer> newRet = new ArrayList<>();
        for (int i = curVals.size() - 1; i > -1; i--) {
            newRet.add(curVals.get(i));
        }
        return newRet;
    }

    public static void main(String[] args) {
        ZigzagLevelTree solution = new ZigzagLevelTree();
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        right1.right = right2;
        System.out.println(solution.zigzagLevelOrder(root));
    }


}
