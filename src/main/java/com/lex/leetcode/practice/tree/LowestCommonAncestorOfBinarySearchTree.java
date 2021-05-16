package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 中等
 *
 * @author lifeng
 */
public class LowestCommonAncestorOfBinarySearchTree {

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

    public TreeNode lowestCommonAncestorTwice(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        List<TreeNode> pPath = scanPath(root, p);
        List<TreeNode> qPath = scanPath(root, q);
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {

            // 因为从根节点开始遍历，所以需要找到最后一个符合要求的parent
            if (pPath.get(i) == qPath.get(i)) {
                ancestor = pPath.get(i);
            } else {
                break;
            }

        }

        return ancestor;
    }

    private List<TreeNode> scanPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode parent = root;
        while (parent != null) {
            path.add(parent);
            if (node.val > parent.val) {
                parent = parent.right;
            } else {
                parent = parent.left;
            }
        }
        return path;
    }

    /**
     * 利用二叉搜索树的性质，合理搜索
     * 搜索二叉树可以应用这个思路，但是普通的二叉树不能这么做！！！
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorOnce(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinarySearchTree solution = new LowestCommonAncestorOfBinarySearchTree();
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;

        System.out.println(solution.lowestCommonAncestorOnce(root, n1, n2).val);

        System.out.println(solution.lowestCommonAncestorTwice(root, n1, n2).val);



    }

}
