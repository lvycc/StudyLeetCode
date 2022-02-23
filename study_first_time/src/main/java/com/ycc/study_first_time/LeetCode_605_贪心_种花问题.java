package com.ycc.study_first_time;

/**
 * @author WangBingYan
 * @date 2022/2/23
 * @description
 */
public class LeetCode_605_贪心_种花问题 {

    /**
     * 取局部最优解，一个位置可以种花那么它的上一个位置和下一个位置都要为0，种花后的位置设置为1
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            int pre = i - 1 >= 0 ? i - 1 : 0;
            int next = i + 1 >= flowerbed.length ? i : i + 1;
            if (flowerbed[pre] == 0 && flowerbed[i] == 0 && flowerbed[next] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

}
