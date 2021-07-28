package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/longest-happy-string/
 * 中等
 * 最长快乐字符串
 * aaa bbb ccc这种就叫快乐串，那么子串里一个字母最多重复2次
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/26 下午10:06
 */
public class LongestDiverseString {

    public String longestDiverseString(int a, int b, int c) {
        int[] charNums = new int[]{a, b, c};
        char[] result = new char[a + b + c];
        int index = 0;
        while (charNums[0] != 0 || charNums[1] != 0 || charNums[2] != 0) {
            char next;
            if (index < 2 || result[index - 1] != result[index - 2]) {
                // 选择剩余个数最多的字母
                next = nextChar(charNums, ' ');
            } else {
                // 选择剩余与最后一个字母不一样的剩下2个字母里个数最多的字母
                next = nextChar(charNums, result[index - 1]);
            }
            // 如果存在字母消费完毕，退出
            if (charNums[next - 'a'] <= 0) {
                break;
            }
            charNums[next - 'a']--;
            result[index++] = next;
        }
        return new String(result, 0, index);
    }

    private char nextChar(int[] charNums, char curChar) {
        char next;
        if (curChar == 'a') {
            next = charNums[1] > charNums[2] ? 'b' : 'c';
        } else if (curChar == 'b') {
            next = charNums[0] > charNums[2] ? 'a' : 'c';
        } else if (curChar == 'c') {
            next = charNums[0] > charNums[1] ? 'a' : 'b';
        } else {
            // 未知情况下，进行2次选择
            next = charNums[0] > charNums[1] ? 'a' : 'b';
            next = charNums[next - 'a'] > charNums[2] ? next : 'c';
        }
        return next;
    }

    public static void main(String[] args) {
        {
            LongestDiverseString lds = new LongestDiverseString();
            // ccaccbcc
            System.out.println(lds.longestDiverseString(1, 1, 7));
        }

        {
            LongestDiverseString lds = new LongestDiverseString();
            // aabbc bacba
            System.out.println(lds.longestDiverseString(2, 2, 1));
        }

        {
            LongestDiverseString lds = new LongestDiverseString();
            // aabaa
            System.out.println(lds.longestDiverseString(7, 1, 0));
        }
    }


}
