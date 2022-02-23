package com.ycc.study_first_time;

/**
 * @author WangBingYan
 * @date 2022/2/23
 * @description
 */
public class LeetCode_55_贪心_跳跃游戏 {

    /**
     * 采用一个索引表示当前可以到达的最大位置的下标，在遍历数组的过程中不断修改下标
     * 如果跳跃次数大于当前的最大索引那就替换该索引
     * 如果当前位置已经到达最大索引位置，则需要以当前位置开始进行重新计算可达最大位置的下标
     * 如果当前位置为0表示不可达
     * 否则继续进行迭代
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
