package com.ycc.huawei_questions;

import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/18
 * @desc 勾股元组数
 * 如果三个正整数A B C ,A²+B²=C²则为勾股数
 * 如果ABC之间两两互质，即A与B A与C B与C均互质没有公约数，
 * 则称其为勾股数元组。
 * 请求出给定n m 范围内所有的勾股数元组
 * 输入描述
 * 起始范围 1<n<10000    n<m<10000
 * 输出目描述
 * abc 保证a<b<c输出格式  a b c
 * 多组勾股数元组 按照a升序b升序 c升序的排序方式输出。
 * 给定范围内，找不到勾股数元组时，输出  Na
 *
 *  案例
 *  输入
 *   1
 *   20
 *  输出
 *    3 4 5
 *    5 12 13
 *    8 15 17
 *
 *  输入
 *     5
 *     10
 *  输出
 *     Na
 */
public class GouGuNumber_1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        // 暴力遍历
        for (int i = n; i <= m - 2; i++) {
            for (int j = i + 1; j <= m - 1; j++) {
                for (int k = j + 1; k <= m; k++) {
                    if (i * i + j * j == k * k && gcd(i, j) == 1 && gcd(j, k) == 1) {
                        System.out.println(i + " " + j + " " + k);
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("Na");
        }
    }

    /**
     * 辗转相除求两数互质
     * 公式：两数相除，用除数除以余数，直到余数为零，得到的最大公约数为1表示两数互质，否则返回最大公约数的值
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
