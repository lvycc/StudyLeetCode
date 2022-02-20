package com.ycc.huawei_questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc 区间字符串倒转输出
 *
 * 输入一个英文文章片段
 *         翻转指定区域的单词顺序
 *         标点符号和普通字母一样处理
 *         例如输入字符串 I am a developer.
 *         [0,3]
 *         则输出 developer. a am I
 *
 *         输入描述
 *          使用换行隔开3个参数
 *          第一个参数为文章内容 即英文字符串
 *          第二个参数为翻转起始单词下标，下标从0开始
 *          第三个参数为结束单词下标
 *
 *          输出描述
 *
 *          翻转后英文文章片段每个单词之间以一个半角空格分割输出
 *
 *          例子
 *
 *           输入
 *            I am a developer.
 *            0
 *            3
 *           输出
 *            I a am developer.
 *
 *           输入
 *             hello world!
 *           0
 *           3
 *           输出
 *           world! hello
 *
 * 输入字符串可以在前面或者后面包含多个空格
 * 但是翻转后的字符不能包括
 *
 * 指定反转区间只有一个单词
 * 或无有效单词
 * 则输出EMPTY
 */
public class StringFanzhuan_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        if (start >= end) {
            System.out.println("EMPTY");
        }

        System.out.println(forImpl(start, end, words));
        System.out.println(sortImpl(start, end, words));
    }

    static String sortImpl(int start, int end, String[] words) {
        for (int i = start; i <= end; i++) {
            int j = end;
            String tmp = words[i];
            words[i] = words[end--];
            words[j] = tmp;
        }
        StringBuilder result = new StringBuilder();
        for (String str : words) {
            if (!"".equals(str)) {
                result.append(str).append(" ");
            }
        }
        return result.toString().trim();
    }

    static String forImpl(int start, int end, String[] words) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = end; i < words.length; i++) {
            if (i >= start && i <= end) {
                if (!"".equals(words[j])) {
                    result.append(words[j])
                            .append(" ");
                }
                j--;
            } else {
                if (!"".equals(words[i])) {
                    result.append(words[i])
                            .append(" ");
                }
            }
        }
        return result.toString().trim();
    }

}
