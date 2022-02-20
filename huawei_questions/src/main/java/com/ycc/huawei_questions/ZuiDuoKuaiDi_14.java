package com.ycc.huawei_questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc 装最多快递
 *
 * 一辆运送快递的货车
 *         运送的快递放在大小不等的长方体快递盒中
 *         为了能够装载更多的快递同时不能让货车超载
 *         需要计算最多能装多少个快递
 *         注：快递的体积不受限制
 *         快递数最多1000个
 *         货车载重最大50000
 *         输入描述
 *          第一行输入每个快递的重量
 *          用英文逗号隔开
 *          如 5,10,2,11
 *          第二行输入货车的载重量
 *           如 20
 *         输出描述
 *          输出最多能装多少个快递
 *          如 3
 *          示例一
 *           输入
 *           5,10,2,11
 *           20
 *           输出
 *           3
 */
public class ZuiDuoKuaiDi_14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] things = scanner.nextLine().split(",");
        int maxNum = Integer.parseInt(scanner.nextLine());
        int[] array = new int[things.length];
        for (int i = 0; i < things.length; i++) {
            array[i] = Integer.parseInt(things[i]);
        }
        Arrays.sort(array);
        int totalNum = 0;
        int totalWeight = 0;
        for (int i = 0; i < array.length; i++) {
            totalWeight += array[i];
            if (totalWeight > maxNum) {
                break;
            }
            totalNum++;
        }
        System.out.println(totalNum);
    }

}
