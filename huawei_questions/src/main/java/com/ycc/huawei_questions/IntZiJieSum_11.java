package com.ycc.huawei_questions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc int 字节和
 *
 *  对一个数据a进行分类
 *         分类方法是 此数据a(4个字节大小)的4个字节相加对一个给定值b取模
 *         如果得到的结果小于一个给定的值c则数据a为有效类型
 *         其类型为取模的值
 *         如果得到的结果大于或者等于c则数据a为无效类型
 *
 *         比如一个数据a=0x01010101 b=3
 *         按照分类方法计算  (0x01+0x01+0x01+0x01)%3=1
 *         所以如果c等于2 则此a就是有效类型  其类型为1
 *         如果c等于1 则此a是无效类型
 *
 *          又比如一个数据a=0x01010103 b=3
 *          按分类方法计算(0x01+0x01+0x01+0x03)%3=0
 *          所以如果c=2则此a就是有效类型  其类型为0
 *          如果c等于0 则此a是无效类型
 *
 *          输入12个数据
 *          第一个数据为c  第二个数据为b
 *          剩余10个数据为需要分类的数据
 *
 *          请找到有效类型中包含数据最多的类型
 *          并输出该类型含有多少个数据
 *
 *          输入描述
 *          输入12个数据用空格分割
 *          第一个数据为c  第二个数据为b
 *          剩余10个数据为需要分类的数据
 *
 *          输出描述
 *          请找到有效类型中包含数据最多的类型
 *          并输出该类型含有多少个数据
 *
 *          实例：
 *            输入
 *              3 4 256 257 258 259 260 261 262 263 264 265
 *            输出
 *              3
 *            说明
 *            这10个数据4个字节相加后的结果分别是
 *             1 2 3 4 5 6 7 8 9 10
 *             故对4取模的结果为
 *             1 2 3 0 1 2 3 0 1 2
 *             c是3所以012都是有效类型
 *             类型为1和2的有3个数据
 *             类型为0和3的只有两个
 *
 *          例子2
 *          输入
 *          1 4 256 257 258 259 260 261 262 263 264 265
 *          输出
 *          2
 */
public class IntZiJieSum_11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int c = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        Map<Integer, Integer> cacheMap = new HashMap<>();
        for (int i = 2; i < strs.length; i++) {
            int key = intGetSum(Integer.parseInt(strs[i])) % b;
            if (key < c) {
                cacheMap.put(key, cacheMap.getOrDefault(key, 0) + 1);
            }
        }
        int max = 0;
        for (Integer value : cacheMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println(max);
    }

    static int intGetSum(int a) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (a >> i * 8);
        }
        return sum;
    }

}
