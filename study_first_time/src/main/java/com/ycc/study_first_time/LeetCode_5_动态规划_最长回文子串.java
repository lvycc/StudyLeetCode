package com.ycc.study_first_time;

/**
 * @author ycc
 * @description
 * @date 2022/2/27
 */
public class LeetCode_5_动态规划_最长回文子串 {

    /**
     * 动态规划求解
     * 要点：
     *  1.如果一个字符p(i,j)为回文子串，那么p(i + 1, j - 1)也是回文子串
     *  2.确定边界p(i,i)肯定为回文子串，p(i,i+1)为回文子串那么s(i)==s(i+1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i < length; i++) {
                int j = i + len - 1;
                if (j >= length) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }
        return s.substring(begin, maxLen + begin);
    }

}
