package com.ycc.study_first_time;

import java.util.Arrays;

/**
 * @author WangBingYan
 * @date 2022/2/23
 * @description
 */
public class LeetCode_455_分发饼干 {

    /**
     * 拉闸写法双重遍历
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int childSum = 0;
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    s[j] = -1;
                    childSum++;
                    break;
                }
            }
        }
        return childSum;
    }

    /**
     * 先排序然后用双指针遍历数组
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int gi = 0;
        int sj = 0;
        while (gi < g.length && sj < s.length) {
            if (s[sj] >= g[gi]) {
                gi++;
            }
            sj++;
        }
        return gi;
    }

}
