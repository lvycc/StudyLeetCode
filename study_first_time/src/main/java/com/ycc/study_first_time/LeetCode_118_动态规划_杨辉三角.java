package com.ycc.study_first_time;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ycc
 * @description
 * @date 2022/2/27
 */
public class LeetCode_118_动态规划_杨辉三角 {

    /**
     * 杨辉三角动态规划
     * 思路：
     *  1.抽象二维数组
     *  2.推演表达式：dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList();
            for (int j = 0; j <= i; j++) {
                list.add(dp[i][j]);
            }
            res.add(list);
        }
        return res;
    }

}
