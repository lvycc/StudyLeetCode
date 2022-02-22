package com.ycc.study_first_time;

/**
 * @author ycc
 * @date 2022/2/23
 * @desc
 */
public class LeetCode_45_跳跃游戏II {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            start = Math.max(start, i + nums[i]);
            if (i == end) {
                end = start;
                step++;
            }
        }
        return step;
    }

}
