package com.lex.leetcode.practice.window;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * middle
 *
 * @author lifeng
 */
public class LongestSubString {

    /**
     * 思路：
     * 1.遍历，直到下一个字符已经出现过，这时记录此时的长度（如果长度比当前最长的小，忽略；否则，更新）
     *
     * o(n^2)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), maxLen = 0;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            set.add(s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                } else {
                    int total = set.size();
                    // 更新最大长度
                    if (total > maxLen) {
                        maxLen = Math.max(maxLen, total);
                    }
                    // 清理当前所有元素
                    set.clear();
                    break;
                }
            }
        }
        return Math.max(maxLen, set.size());
    }

    /**
     * 双指针
     * 相当于当前最大长度如果为N，左指针右移（1）后，右指针也移动1个字符，
     * 此时参考中间这一段字符，是否有重复字符出现
     *
     * o(n)
     * @param s 
     * @return
     */
    public int lengthOfLongestSubstringOn(String s) {
        int max = 0, lp = -1, len = s.length();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < len; i++) {

            // move lp(left point)
            if(i > 0){
                set.remove(s.charAt(i - 1));
            }

            while (lp + 1 < len && !set.contains(s.charAt(lp + 1))) {
                set.add(s.charAt(lp + 1));
                lp++;
            }

            max = Math.max(max, lp - i + 1);
        }

        return max;
    }


    public static void main(String[] args) {
        LongestSubString lss = new LongestSubString();
        System.out.println(lss.lengthOfLongestSubstring(""));
        System.out.println(lss.lengthOfLongestSubstring("abccba"));
        System.out.println(lss.lengthOfLongestSubstring("bbbb"));
        System.out.println(lss.lengthOfLongestSubstring("jbpnbwwd"));
        System.out.println(lss.lengthOfLongestSubstring("pwwkew"));

        System.out.println(lss.lengthOfLongestSubstringOn(""));
        System.out.println(lss.lengthOfLongestSubstringOn("abccba"));
        System.out.println(lss.lengthOfLongestSubstringOn("bbbb"));
        System.out.println(lss.lengthOfLongestSubstringOn("jbpnbwwd"));
        System.out.println(lss.lengthOfLongestSubstringOn("pwwkew"));

    }

}
