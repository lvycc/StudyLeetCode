package com.ycc.study_first_time;

/**
 * @author ycc
 * @description
 * @date 2022/2/27
 */
public class LeetCode_70_动态规划_爬楼梯 {

    /**
     * 动态规划解题爬楼梯
     * 思路：
     *  1.确定子问题，爬到第i层楼梯一共有f(i)种方法
     *  2.确定表达式，f(i) = f(i - 1) + f(i - 2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre1 = 1;
        int pre2 = 2;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }

}
