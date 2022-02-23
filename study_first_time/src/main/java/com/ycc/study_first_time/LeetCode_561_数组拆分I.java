package com.ycc.study_first_time;

import java.util.Arrays;

/**
 * @author WangBingYan
 * @date 2022/2/23
 * @description
 */
public class LeetCode_561_数组拆分I {

    /**
     * 排序后取每次取第二大的数字进行累加即可
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int index = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (index % 2 == 0) {
                sum += nums[i];
            }
            index++;
        }
        return sum;
    }

}
