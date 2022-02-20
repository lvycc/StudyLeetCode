package com.ycc.huawei_questions;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc 身高排序（绝对差值）
 * 小明今年升学到了小学1年纪
 *          来到新班级后，发现其他小朋友身高参差不齐
 *          然后就想基于各小朋友和自己的身高差，对他们进行排序
 *          请帮他实现排序
 *          输入描述
 *           第一行为正整数 h和n
 *           0<h<200 为小明的身高
 *           0<n<50 为新班级其他小朋友个数
 *           第二行为n各正整数
 *            h1 ~ hn分别是其他小朋友的身高
 *          取值范围0<hi<200
 *          且n个正整数各不相同
 *
 *          输出描述
 *           输出排序结果，各正整数以空格分割
 *           和小明身高差绝对值最小的小朋友排在前面
 *           和小明身高差绝对值最大的小朋友排在后面
 *           如果两个小朋友和小明身高差一样
 *           则个子较小的小朋友排在前面
 *
 *           示例一
 *           输入
 *           100 10
 *           95 96 97 98 99 101 102 103 104 105
 *           输出
 *            99 101 98 102 97 103 96 104 95 105
 *
 *           说明  小明身高100
 *           班级学生10个  身高分别为
 */
public class HeightSort_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int targetHeight = Integer.parseInt(line1[0]);
        int totalStudent = Integer.parseInt(line1[1]);
        System.out.println(treeMapImpl(targetHeight, line2));
        System.out.println(sortImpl(targetHeight, line2));
    }

    static List<Integer> treeMapImpl(int targetHeight, String[] line2) {
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for (String high : line2) {
            int highAbs = Math.abs(Integer.parseInt(high) - targetHeight);
            if (treeMap.containsKey(highAbs)) {
                List<Integer> cacheList = treeMap.get(highAbs);
                cacheList.add(Integer.parseInt(high));
            } else {
                List<Integer> cacheList = new ArrayList<>();
                cacheList.add(Integer.parseInt(high));
                treeMap.put(highAbs, cacheList);
            }
        }
        List<Integer> result = new ArrayList<>();
        treeMap.forEach(new BiConsumer<Integer, List<Integer>>() {
            @Override
            public void accept(Integer integer, List<Integer> integers) {
                Collections.sort(integers);
                result.addAll(integers);
            }
        });
        return result;
    }

    static List<Integer> sortImpl(int targetHeight, String[] line2) {
        List<Integer> highs = new ArrayList<>(line2.length);
        for (String str : line2) {
            highs.add(Integer.parseInt(str));
        }
        Collections.sort(highs, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1 - targetHeight);
                int abs2 = Math.abs(o2 - targetHeight);
                if (abs1 == abs2) {
                    return o1 - o2;
                }
                return abs1 - abs2;
            }
        });
        return highs;
    }

}
