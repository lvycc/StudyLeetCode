package com.ycc.study_first_time;

/**
 * @author WangBingYan
 * @date 2022/2/23
 * @description
 */
public class LeetCode_11_盛最多水的容器 {

    /**
     * 采用双指针求解最大面积，每次求解后移动高度较小的指针，直至两指针相遇
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

}
