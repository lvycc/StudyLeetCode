package com.ycc.study_first_time;

/**
 * @author ycc
 * @description
 * @date 2022/2/27
 */
public class LeetCode_53_动态规划_最大子数组和 {

    /**
     * 暴力遍历方式解，根据最大的数组长度以滑动窗口形式遍历，但是会超时
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int maxSum = Integer.MIN_VALUE;
        while (len > 0) {
            for (int startIndex = 0; startIndex <= nums.length - len; startIndex++) {
                int sum = 0;
                for (int i = startIndex; i < nums.length && i < startIndex + len; i++) {
                    sum += nums[i];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
            len--;
        }
        return maxSum;
    }

    /**
     * 动态规划解题
     * 思路：
     *  1.确定问题，连续的子序列，不限制序列长度，只要求和最大
     *  2.提取子问题，可以提取为以数组元素nums[i]结尾的连续子序列和最大的问题。
     *      为什么提取该子问题？
     *      2.1.为了更好的确定问题边界
     *      2.2.涵盖了所有可能的情况，不管连续子序列多长，以元素nums[i]结尾的序列已经包含了全部情况
     *  3.确定表达式
     *      3.1.第i个元素结尾的子序列最大和只与以第i-1个元素子序列的最大和有关
     *      3.2.可以确定表达式f(i)=max(nums[i], f(i-1) + nums[i])，因为以i结尾的最大子序列比i-1结尾
     *      的最大子序列多了第i个元素，因此可以推算出该表达式
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[i - 1] + nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
