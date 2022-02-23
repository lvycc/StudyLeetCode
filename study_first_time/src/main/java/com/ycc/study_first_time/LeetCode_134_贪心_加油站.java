package com.ycc.study_first_time;

/**
 * @author ycc
 * @date 2022/2/23
 * @desc
 */
public class LeetCode_134_贪心_加油站 {

    public static void main(String[] args) {
        int[] gas = {5, 8, 2, 8};
        int[] cost = {6,5,6,6};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 定义开始节点为0，当前剩余油量，最终剩余油量
     * 如果最终剩余油量小于0则肯定不能到达
     * 如果当前剩余油量小于0则从当前位置下一个位置重新计算
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int leaveGas = 0;
        int start = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            leaveGas += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (leaveGas < 0) {
                leaveGas = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }

}
