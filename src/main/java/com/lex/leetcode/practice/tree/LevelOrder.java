package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 中等
 *
 * @author lifeng
 */
public class LevelOrder {

    /**
     * 按层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null){
            return ret;
        }
        List<TreeNode> levelNodes = new ArrayList<TreeNode>();
        levelNodes.add(root);
        while(levelNodes.size() > 0){
            List<Integer> levelValList = new ArrayList<Integer>();
            List<TreeNode> tmpNodes = new ArrayList<TreeNode>();
            for(TreeNode node : levelNodes){
                levelValList.add(node.val);
                if(node.left != null){
                    tmpNodes.add(node.left);
                }
                if(node.right != null){
                    tmpNodes.add(node.right);
                }
            }
            if(levelValList.size() > 0){
                ret.add(levelValList);
            }
            levelNodes = tmpNodes;
        }
        return ret;
    }

    public static void main(String[] args) {
        LevelOrder solution = new LevelOrder();
        solution.levelOrder(null);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
