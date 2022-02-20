package com.ycc.huawei_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc GPU 算力
 *
 * 为了充分发挥Gpu算力，
 *          需要尽可能多的将任务交给GPU执行，
 *          现在有一个任务数组，
 *          数组元素表示在这1s内新增的任务个数，
 *          且每秒都有新增任务，
 *          假设GPU最多一次执行n个任务，
 *          一次执行耗时1s，
 *          在保证Gpu不空闲的情况下，最少需要多长时间执行完成。
 *
 *          输入描述
 *            第一个参数为gpu最多执行的任务个数
 *            取值范围1~10000
 *            第二个参数为任务数组的长度
 *            取值范围1~10000
 *            第三个参数为任务数组
 *            数字范围1~10000
 *
 *          输出描述
 *            执行完所有任务需要多少秒
 *
 *          例子
 *            输入
 *             3
 *             5
 *             1 2 3 4 5
 *            输出
 *             6
 *
 *             说明，一次最多执行3个任务  最少耗时6s
 *
 *           例子2
 *             输入
 *              4
 *              5
 *              5 4 1 1 1
 *             输出
 *              5
 *
 *            说明，一次最多执行4个任务  最少耗时5s
 */
public class GpuCalculate_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gpuCalculate = Integer.parseInt(scanner.nextLine());
        int taskSize = Integer.parseInt(scanner.nextLine());
        String[] taskStrs = scanner.nextLine().split(" ");
        int totalTime = 0;
        int moreTask = 0;
        for (String taskStr : taskStrs) {
            int taskNum = Integer.parseInt(taskStr);
            if (taskNum + moreTask > gpuCalculate) {
                moreTask += taskNum + moreTask - gpuCalculate;
            } else {
                moreTask = 0;
            }
            totalTime++;
        }
        while (moreTask > 0) {
            moreTask -= gpuCalculate;
            totalTime++;
        }
        System.out.println(totalTime);
    }



}
