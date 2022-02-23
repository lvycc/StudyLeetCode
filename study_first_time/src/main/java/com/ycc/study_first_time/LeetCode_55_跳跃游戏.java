package com.ycc.study_first_time;

/**
 * @author WangBingYan
 * @date 2022/2/23
 * @description
 */
public class LeetCode_55_跳跃游戏 {

    /**
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        boolean res = true;
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) {
                res = true;
                break;
            }
            if (maxIndex == i && nums[i] == 0) {
                res = false;
                break;
            }
        }
        return res;
    }

}
