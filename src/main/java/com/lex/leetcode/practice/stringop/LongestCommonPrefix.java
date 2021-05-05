package com.lex.leetcode.practice.stringop;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 简单
 *
 * 解法：
 * 1.纵向扫描
 * 2.二分查找：找出最短的
 *
 * @author lifeng
 */
public class LongestCommonPrefix {

    /**
     * 找出最短的一个字符串，然后根据遍历这个字符串的每个字符，看其他字符串是否有相同的字符
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < strs[minIndex].length()) {
                minIndex = i;
            }
        }

        int curLen = 0;
        for (int k = 0; k < strs[minIndex].length(); k++) {
            for (String str : strs) {
                if (str.charAt(k) != strs[minIndex].charAt(k)) {
                    return strs[minIndex].substring(0, curLen);
                }
            }
            curLen++;
        }
        return strs[minIndex].substring(0, curLen);
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        String[] strs = new String[]{
                "flower", "flow", "flight"
        };
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{
                "dog", "racecar", "car"
        };
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{};
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{"a"};
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{"a", "a"};
        System.out.println(solution.longestCommonPrefix(strs));

        strs = new String[]{"ab", "ab"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

}
