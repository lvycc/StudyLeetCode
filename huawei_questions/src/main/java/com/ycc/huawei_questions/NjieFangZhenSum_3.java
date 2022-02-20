package com.ycc.huawei_questions;

import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc n 阶方阵和
 *
 * 给出n阶方阵里所有数
 *         求方阵里所有数的和
 *         输入描述：
 *           输入有多个测试用例
 *           每个测试用例第一个第一个整数n   n<=1000 表示方阵阶数为n
 *           接下来是n行的数字，每行n个数字用空格隔开
 *         输出描述：
 *           输出一个整数表示n阶方阵的和
 *         例子：
 *           输入
 *               3
 *               1 2 3
 *               2 1 3
 *               3 2 1
 *           输出
 *               18
 */
public class NjieFangZhenSum_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                sum += Integer.valueOf(line[j]);
            }
        }
        System.out.println(sum);
    }

}
