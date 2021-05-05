package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 中等
 *
 * @author lifeng
 */
public class NTreeLevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {

        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelValList = new ArrayList<>();
            while (size > 0){
                Node cur = queue.poll();
                levelValList.add(cur.val);
                if(cur.children != null && cur.children.size() > 0){
                    for(Node child : cur.children){
                        queue.offer(child);
                    }
                }
                size--;
            }
            ans.add(levelValList);
        }

        return ans;
    }

}
