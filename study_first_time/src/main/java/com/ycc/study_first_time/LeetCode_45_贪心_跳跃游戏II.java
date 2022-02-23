package com.ycc.study_first_time;

/**
 * @author ycc
 * @date 2022/2/23
 * @desc
 */
public class LeetCode_45_贪心_跳跃游戏II {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    /**
     * 定义当前遍历过程中可以到达的最大值，当前步数的结束点，当前走的步数
     * 从0开始迭代，计算出当前遍历节点可以到达的最大位置，
     * 如果当前遍历节点与步数结束点相等，表示已经遍历完成该步数内可以到达的最大值，
     * 并且该最大值已经被记录，这时步数加一，结束节点为当前可以到达的最大值
     * 因为下一步是以当前节点开始，当前节点能到达的最大步数就是这一步的结束位置
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                step++;
                end = maxPosition;
            }
        }
        return step;
    }

}
