package com.ycc.study_first_time;

/**
 * @author ycc
 * @description
 * @date 2022/2/27
 */
public class LeetCode_121_动态规划_买卖股票的最佳时机 {

    /**
     * 动态规划求解：
     *  1.确定问题子结构，计算第i天卖出的最大收益
     *  2.第i天卖出的最大收益等于当前股票价格减去当天之前股票最低价的一天的价格
     *  3.遍历数组，如果当前数组值-最小股票价格小于0则当前位置为股票最低价格
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        int buyIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[buyIndex];
            maxPrice = Math.max(maxPrice, tmp);
            if (tmp < 0) {
                buyIndex = i;
            }
        }
        return maxPrice;
    }

}
