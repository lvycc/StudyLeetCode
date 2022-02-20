package com.ycc.huawei_questions;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc 字符串排序
 *
 * 给定两个字符串
 *         从字符串2中找出字符串1中的所有字符
 *         去重并按照ASCII码值从小到大排列
 *         输入字符串1长度不超过1024
 *         字符串2长度不超过100
 *
 *         字符范围满足ASCII编码要求，按照ASCII由小到大排序
 *
 *         输入描述：
 *          bach
 *          bbaaccddfg
 *          输出
 *           abc
 *
 *           2
 *           输入
 *           fach
 *           bbaaccedfg
 *           输出
 *           acf
 */
public class StringSort_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] targetChars = scanner.nextLine().toCharArray();
        char[] baseChars = scanner.nextLine().toCharArray();
        TreeSet<Character> result = new TreeSet<>();
        for (char target : targetChars) {
            for (char base : baseChars) {
                if (target == base) {
                    result.add(base);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character c : result) {
            res.append(c);
        }
        System.out.println(res.toString());
    }

}
