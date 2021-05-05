package com.lex.leetcode.practice.back;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses
 * 中等
 *
 * @author lifeng
 */
public class GenerateParenthesis {

    public List<String> generateParenthesisBack(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     * 1.左括号个数不大于n，则可以继续添加；
     * 2.右括号个人不大于左括号，则可以继续添加；
     *
     * @param ans
     * @param sb
     * @param leftNo
     * @param rightNo
     * @param max
     */
    private void backtrack(List<String> ans, StringBuilder sb, int leftNo, int rightNo, int max) {
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }
        if (leftNo < max) {
            sb.append("(");
            backtrack(ans, sb, leftNo + 1, rightNo, max);
            // 进入不添加左括号的逻辑
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightNo < leftNo) {
            sb.append(")");
            backtrack(ans, sb, leftNo, rightNo + 1, max);
            // 进入不添加右括号的逻辑
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        {
            GenerateParenthesis solution = new GenerateParenthesis();
            System.out.println(solution.generateParenthesisBack(3));

            System.out.println(solution.generateParenthesisBack(1));
        }
    }

}
