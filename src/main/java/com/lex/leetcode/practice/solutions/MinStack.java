package com.lex.leetcode.practice.solutions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * 简单
 *
 * @author lifeng
 */
public class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.xStack = new LinkedList<>();
        this.minStack = new LinkedList<>();
        this.minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        this.xStack.push(val);
        this.minStack.push(Math.min(this.minStack.getFirst(), val));
    }

    public void pop() {
        this.xStack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.xStack.getFirst();
    }

    public int getMin() {
        return this.minStack.getFirst();
    }

    public static void main(String[] args) {
        {
            MinStack ms = new MinStack();
            ms.push(-2);
            ms.push(0);
            ms.push(-3);

            // -3
            System.out.println(ms.getMin());

            ms.pop();
            System.out.println(ms.top());

            // -2
            System.out.println(ms.getMin());
        }
    }

}
