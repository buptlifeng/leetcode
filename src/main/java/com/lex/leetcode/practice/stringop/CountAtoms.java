package com.lex.leetcode.practice.stringop;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/number-of-atoms/
 * 困难
 *
 * @author lifeng
 */
public class CountAtoms {

    /**
     * i++和++i是有区别的
     * 如果i=1
     * int factor = i++; factor=0,i=2
     * int factor = ++1; factor=1,i=2
     * factor的赋值有差异
     *
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        int len = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        for (int i = 0; i < len; ) {
            if (formula.charAt(i) == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> ele = stack.pop();
                // 系数开始下标(从右括号后一位开始) 默认系数为1
                int factorStartIndex = ++i, multi = 1;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > factorStartIndex) {
                    multi = Integer.parseInt(formula.substring(factorStartIndex, i));
                }
                // 更新每个元素的总数
                for (String ch : ele.keySet()) {
                    int cnt = ele.get(ch);
                    stack.peek().put(ch, stack.peek().getOrDefault(ch, 0) + multi * cnt);
                }
            } else {
                int factorStartIndex = i++;
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String eleName = formula.substring(factorStartIndex, i);
                // 检查元素后有无数量标记
                factorStartIndex = i;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int times = i > factorStartIndex ? Integer.parseInt(formula.substring(factorStartIndex, i)) : 1;
                // 更新括号内元素的计数
                stack.peek().put(eleName, stack.peek().getOrDefault(eleName, 0) + times);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String name : stack.peek().keySet()) {
            sb.append(name);
            int multi = stack.peek().get(name);
            if (multi > 1) {
                sb.append(multi);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAtoms solution = new CountAtoms();
        //System.out.println(solution.countOfAtoms("H2O"));

        System.out.println(solution.countOfAtoms("Mg(OH)2"));

        System.out.println(solution.countOfAtoms("K4(ON(SO3)2)2"));
    }

}
