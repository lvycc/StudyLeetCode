package com.ycc.study_first_time;

/**
 * @author ycc
 * @date 2022/2/23
 * @desc 此题也可以用动态规划解题，待后续补充动态规划
 * TODO 动态规划解题方案
 */
public class LeetCode_122_贪心_买卖股票的最佳时机II {

    /**
     * 使用贪心策略，第二天的金额大于第一天就在前一天买入第二天卖掉，以此类推
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxMoney = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxMoney += prices[i] - prices[i - 1];
            }
        }
        return maxMoney;
    }
}
