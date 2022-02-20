package com.ycc.huawei_questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc 购买最多商品
 *
 * 双11众多商品进行打折销售，小明想购买一些自己心意的商品
 *     但由于受购买资金限制，所以他决定从众多心意商品中购买3件
 *     而且想尽可能的花完资金
 *     现在请你设计一个程序帮助小明计算尽可能花费的最大资金额
 *
 *     输入描述
 *      第一行为整型数组M 数组长度小于100 数组元素记录单个商品的价格
 *      单个商品价格<1000
 *      第二行输入为购买资金的额度R
 *      R<100000
 *
 *     输出描述
 *      输出为满足上述条件的最大花费额度
 *      如果不存在满足上述条件的商品请返回-1
 *
 *     例子1
 *     输入
 *      23,26,36,27
 *      78
 *     输出
 *      76
 *
 *     例子2
 *         输入
 *          23,30,40
 *          26
 *         输出
 *           -1
 *
 *     备注：输入格式正确
 */
public class BuyMuchThings_9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(",");
        int totoalMoney = Integer.parseInt(scanner.nextLine());
        int[] things = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            things[i] = Integer.parseInt(line[i]);
        }
        int maxMoney = -1;
        for (int i = 0; i < things.length; i++) {
            for (int j = i + 1; j < things.length; j++) {
                for (int k = j + 1; k < things.length; k++) {
                    int sum = things[i] + things[j] + things[k];
                    if (sum < totoalMoney && sum > maxMoney) {
                        maxMoney = sum;
                    }
                }
            }
        }
        System.out.println(maxMoney);
    }

}
