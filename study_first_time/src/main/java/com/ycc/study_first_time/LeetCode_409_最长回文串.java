package com.ycc.study_first_time;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangBingYan
 * @date 2022/2/22
 * @description 最长回文子串
 */
public class LeetCode_409_最长回文串 {

    class Solution {
        public int longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            // 用hash表缓存字符出现次数
            Map<Character, Integer> cacheMap = new HashMap<>();
            for (char aChar : chars) {
                cacheMap.put(aChar, cacheMap.getOrDefault(aChar, 0) + 1);
            }
            int length = 0;
            for (Integer value : cacheMap.values()) {
                // 每次只添加能够组成回文子串的字符个数
                length += value - value % 2;
            }
            // 如果不满足最大长度与总字符个数一致，则需要额外加一回文子串最多有一个字符为单数
            return length == chars.length ? length : length + 1;
        }
    }

}
