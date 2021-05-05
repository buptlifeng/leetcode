package com.lex.leetcode.practice.atoi;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author lifeng
 */
public class String2Int {

    /**
     * 根据官方提示，使用有限状态机法实现
     * * * * *      ""      +/-     number      other
     * start        start   signed  in_number   end
     * signed       end     end     in_number   end
     * in_number    end     end     in_number   end
     * end          end     end     end         end
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        Automation automation = new Automation();
        for (char ch : s.toCharArray()) {
            automation.get(ch);
        }
        return (int) (automation.sign * automation.ret);
    }

    class Automation {
        private String state = "start";
        private int sign = 1;
        private long ret = 0;
        private Map<String, String[]> stateMap = new HashMap<String, String[]>() {
            {
                put("start", new String[]{"start", "signed", "in_number", "end"});
                put("signed", new String[]{"end", "end", "in_number", "end"});
                put("in_number", new String[]{"end", "end", "in_number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };

        public void get(char ch) {
            state = stateMap.get(state)[getState(ch)];
            if ("in_number".equals(state)) {
                ret = ret * 10 + ch - '0';
                ret = sign == 1 ? Math.min(ret, Integer.MAX_VALUE) : Math.min(ret, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = ch == '+' ? 1 : -1;
            }
        }

        public int getState(char ch) {
            if (ch == ' ') {
                return 0;
            } else if (ch == '+' || ch == '-') {
                return 1;
            } else if (ch >= '0' && ch <= '9') {
                return 2;
            }
            return 3;
        }
    }

}
