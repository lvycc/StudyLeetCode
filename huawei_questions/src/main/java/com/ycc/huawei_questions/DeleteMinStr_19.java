package com.ycc.huawei_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/20
 * @desc 删除出现次数最少字符串
 * 删除字符串中出现次数最少的字符
 *     如果多个字符出现次数一样则都删除
 *
 *     例子：
 *     输入
 *       abcdd
 *       字符串中只
 *      输出
 *       dd
 *
 *     输入
 *       aabbccdd
 *
 *     输出
 *       empty
 *
 *       如果都被删除  则换为empty
 */
public class DeleteMinStr_19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<Character, Integer> cacheMap = new HashMap<>();
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            cacheMap.put(chars[i], cacheMap.getOrDefault(chars[i], 0) + 1);
        }
        int minStrNum = Integer.MAX_VALUE;
        for (Integer value : cacheMap.values()) {
            if (value < minStrNum) {
                minStrNum = value;
            }
        }
        StringBuilder result = new StringBuilder();
        for (char aChar : chars) {
            if (!cacheMap.get(aChar).equals(minStrNum)) {
                result.append(aChar);
            }
        }
        if (result.length() == 0) {
            System.out.println("empty");
        } else {
            System.out.println(result.toString());
        }
    }

}
