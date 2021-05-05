package com.lex.leetcode.practice.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 简单
 *
 * @author lifeng
 */
public class BinaryTreePaths {

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
     * 迭代写法
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePathsIterate(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        Queue<String> pathQueue = new LinkedList<>();
        pathQueue.offer(String.valueOf(root.val));

        while (!nodes.isEmpty()) {
            TreeNode curNode = nodes.poll();
            String path = pathQueue.poll();
            if (curNode.left == null && curNode.right == null) {
                paths.add(path);
            } else {
                if (curNode.left != null) {
                    nodes.offer(curNode.left);
                    pathQueue.add(path + "->" + curNode.left.val);
                }
                if (curNode.right != null) {
                    nodes.offer(curNode.right);
                    pathQueue.add(path + "->" + curNode.right.val);
                }
            }
        }
        return paths;
    }

    /**
     * 递归写法
     * 返回所有从根到叶子的路径
     * 思路：
     * 1.记录到当前节点的所有父节点
     * 2.判断是否为叶子节点，如果是，记录路径，记录完成之后，移除当前节点，返回到父节点
     * 3.如果不是，则继续遍历子节点；
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePathsRecursion(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        Stack<TreeNode> pNodes = new Stack<>();
        helper(root, pNodes, paths);
        return paths;
    }


    private void helper(TreeNode node, Stack<TreeNode> pNodes, List<String> paths) {
        if (node == null) {
            return;
        }
        // 先放入
        pNodes.push(node);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode pNode : pNodes) {
                sb.append(pNode.val).append("->");
            }
            // 移除最后多余的->
            paths.add(sb.toString().substring(0, sb.length() - 2));
        } else {
            if (node.left != null) {
                helper(node.left, pNodes, paths);
            }
            if (node.right != null) {
                helper(node.right, pNodes, paths);
            }
        }

        // 在弹出
        pNodes.pop();
    }

    public static void main(String[] args) {
        BinaryTreePaths solution = new BinaryTreePaths();
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);

        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;
        System.out.println(solution.binaryTreePathsRecursion(root));

        System.out.println(solution.binaryTreePathsIterate(root));
    }

}
