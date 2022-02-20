package com.ycc.huawei_questions;

import java.util.*;

/**
 * @author ycc
 * @date 2022/2/20
 * @desc 磁盘容量排序
 * 磁盘的容量单位常用的有
 *         M G T
 *         他们之间的换算关系为 1T =1024G 1G=1024M
 *         现在给定n块磁盘的容量，请对他们按从小到大的顺序进行稳定排序
 *         例如给定5块盘的容量
 *         5
 *         1T
 *         20M
 *         3G
 *         10G6T
 *         3M12G9M
 *         排序后的结果为
 *         20M
 *         3G
 *         3M 12G 9M
 *         1T,10G 6T
 *         注意单位可以重复出现
 *         上述3M 12G 9M表示的容量即为 3M 12G 9M 和12M 12G相等
 *         输入描述、
 *           输入第一行包含一个整数n
 *           2<=n<=100 表示磁盘的个数
 *           接下来的n行
 *           每行一个字符串
 *           2<长度<30
 *           表示磁盘的容量
 *           由一个或多个格式为MV的子串组成
 *           其中m表示容量大小
 *           v表示容量单位
 *           例如20M 1T
 *           磁盘容量的范围1~1024的正整数
 *           单位 M G T
 *          输出n行
 *          表示n块磁盘容量排序后的结果
 *
 *          实例
 *          输入
 *          3
 *          1G
 *          2G
 *          1024M
 *         输出
 *         1G
 *         1024M
 *         2G
 *         说明：稳定排序要求相等值保留原来位置
 *
 *         示例2
 *         3
 *         2G4m
 *         3M2G
 *         1T
 *         输出
 *         3M2G
 *         2G4M
 *         1T
 */
public class DeskSort_23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        List<String> desks = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            desks.add(scanner.nextLine());
        }
        Collections.sort(desks, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return desk2M(o1) - desk2M(o2) >= 0 ? 1 : -1;
            }
        });
        System.out.println(desks);
    }

    static long desk2M(String desk) {
        long sum = 0;
        int index = 0;
        for (int i = 0; i < desk.length(); i++) {
            switch (desk.charAt(i)) {
                case 'M':
                    sum += Integer.parseInt(desk.substring(index, i));
                    index = i + 1;
                    break;
                case 'G':
                    sum += Integer.parseInt(desk.substring(index, i)) * 1024;
                    index = i + 1;
                    break;
                case 'T':
                    sum += Integer.parseInt(desk.substring(index, i)) * 1024 * 1024;
                    index = i + 1;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }

}
