package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 中等
 *
 * @author lifeng
 */
public class PathSumII {

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

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        dfs(root, targetSum, new LinkedList<>());
        return ans;
    }

    private void dfs(TreeNode node, int remain, LinkedList<Integer> pathList) {
        if (node == null) {
            return;
        }
        pathList.addLast(node.val);
        remain -= node.val;
        if (node.left == null && node.right == null && remain == 0) {
            ans.add(new ArrayList<>(pathList));
        }
        dfs(node.left, remain, pathList);
        dfs(node.right, remain, pathList);
        // 子节点递归结束之后，移除当前节点
        pathList.removeLast();
    }

    public static void main(String[] args) {
        {
            PathSumII ps = new PathSumII();
            TreeNode root = new TreeNode(1);
            TreeNode l1 = new TreeNode(2);
            TreeNode r1 = new TreeNode(3);
            root.left = l1;
            root.right = r1;
            List<List<Integer>> ret = ps.pathSum(root, 5);
            // size=0
            System.out.println(ret);
        }

        {
            PathSumII ps = new PathSumII();

            TreeNode root = new TreeNode(5);
            TreeNode l1 = new TreeNode(4);
            TreeNode r1 = new TreeNode(8);
            root.left = l1;
            root.right = r1;

            TreeNode l1l = new TreeNode(11);
            l1.left = l1l;

            TreeNode l1ll = new TreeNode(7);
            TreeNode l1lr = new TreeNode(2);
            l1l.left = l1ll;
            l1l.right = l1lr;

            TreeNode r1l = new TreeNode(13);
            TreeNode r1r = new TreeNode(4);
            r1.left = r1l;
            r1.right = r1r;

            TreeNode r1rl = new TreeNode(5);
            TreeNode r1rr = new TreeNode(1);
            r1r.left = r1rl;
            r1r.right = r1rr;
            List<List<Integer>> ret = ps.pathSum(root, 22);
            // size=2
            System.out.println(ret);
        }
    }

}
