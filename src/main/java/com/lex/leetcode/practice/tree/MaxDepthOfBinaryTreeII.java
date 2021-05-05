package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 中等
 * AC
 *
 * @author lifeng
 */
public class MaxDepthOfBinaryTreeII {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> levelVals = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                levelVals.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ret.add(levelVals);
        }

        // reverse
        reverse(ret);
        return ret;
    }

    private void reverse(List<List<Integer>> ret) {
        int l = 0, r = ret.size() - 1;
        while (l < r) {
            List<Integer> tmp = ret.get(l);
            ret.set(l, ret.get(r));
            ret.set(r, tmp);
            l++;
            r--;
        }
    }

}
