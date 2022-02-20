package com.ycc.huawei_questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/18
 * @desc 整数对最小和
 */
public class NumMinSum_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int k = scanner.nextInt();
        int[] sumArray = new int[line1.length - 1];
        for (int i = 1; i < line1.length; i++) {
            sumArray[i - 1] = Integer.valueOf(line1[i]) + Integer.valueOf(line2[i]);
        }
        Arrays.sort(sumArray);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += sumArray[i];
        }
        System.out.println(sum);
    }

}
