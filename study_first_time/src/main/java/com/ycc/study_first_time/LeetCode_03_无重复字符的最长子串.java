package com.ycc.study_first_time;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ycc
 * @date 2022/2/22
 * @desc
 */
public class LeetCode_03_无重复字符的最长子串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        Map<Character, Integer> cacheMap = new HashMap<>();
        /**
         * start左指针，end为右指针
         * 遍历移动右指针
         * 一旦碰到相同的字符则移动左指针到最早出现该字符的下一个位置
         */
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (cacheMap.containsKey(s.charAt(end))) {
                start = Math.max(start, cacheMap.get(s.charAt(end)));
            }
            length = Math.max(length, end - start + 1);
            cacheMap.put(s.charAt(end), end + 1);
        }
        return length;
    }

}
