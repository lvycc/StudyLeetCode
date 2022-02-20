package com.ycc.huawei_questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/20
 * @desc 第K长子串
 * 给定一个字符串
 *     只包含大写字母
 *     求在包含同一字母的子串中
 *     长度第K长的子串
 *     相同字母只取最长的子串
 *
 *     输入
 *      第一行 一个子串 1<len<=100
 *      只包含大写字母
 *      第二行为k的值
 *
 *      输出
 *      输出连续出现次数第k多的字母的次数
 *
 *      例子：
 *      输入
 *              AABAAA
 *              2
 *      输出
 *              1
 *        同一字母连续出现最多的A 3次
 *        第二多2次  但A出现连续3次
 *
 *     输入
 *
 *     AAAAHHHBBCDHHHH
 *     3
 *
 *     输出
 *     2
 *
 * //如果子串中只包含同一字母的子串数小于k
 *
 * 则输出-1
 */
public class DiKLengthStr_17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> cacheMap = new HashMap<>();
        Character startChar = str.charAt(0);
        int start = 0;
        int len = 1;
        for (int i = 1; i < str.length(); i++) {
            if (startChar == str.charAt(i)) {
                len++;
            } else {
                String tmp = str.substring(start, start + len);
                if (cacheMap.getOrDefault(tmp, 0) < len) {
                    cacheMap.put(tmp, len);
                }
                start = i;
                len = 1;
                startChar = str.charAt(i);
            }
        }
        if (cacheMap.isEmpty()) {
            cacheMap.put(str, 1);
        }
        Integer[] array = cacheMap.values().toArray(new Integer[]{});
        Arrays.sort(array);
        if (k > array.length) {
            System.out.println(-1);
        } else {
            System.out.println(array[array.length - k]);
        }
    }

}
