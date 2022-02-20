package com.ycc.huawei_questions;

import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc 猴子跳台阶 1级和3级
 * 一天一只顽猴想要从山脚爬到山顶
 *   途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
 *   试问？猴子通过这个阶梯有多少种不同的跳跃方式
 *
 *   输入描述：
 *     输入只有一个这个数n    0<n<50
 *     此阶梯有多个台阶
 *   输出描述：
 *     有多少种跳跃方式
 *
 *   实例:
 *    输入
 *      50
 *    输出
 *       122106097
 *
 *    输入
 *       3
 *    输出
 *       2
 *
 *       递推关系式：
 *       f(1) = 1; f(2) = 1; f(3) = 2; f(4) = 3; f(5) = 4;  => f(n) = f(n - 1) + f(n - 3)  &&  n>3
 */
public class MonkeyTaiJie_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(monkeyUp(n));
        System.out.println(monkeyUp2(n));
    }

    /**
     * 递归写法
     * @param n
     * @return
     */
    public static long monkeyUp(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return monkeyUp(n - 1) + monkeyUp(n - 3);
    }

    /**
     * 递推写法
     * @param n
     * @return
     */
    public static long monkeyUp2(int n) {
        long f1 = 1;
        long f2 = 1;
        long f3 = 2;
        long f4 = n == 1 || n == 2 ? 1 : 2;
        for (int i = 4; i <= n; i++) {
            f4 = f1 + f3;
            f1 = f2;
            f2 = f3;
            f3 = f4;
        }
        return f4;
    }

}
