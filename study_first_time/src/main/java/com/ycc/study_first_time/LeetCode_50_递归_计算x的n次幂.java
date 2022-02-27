package com.ycc.study_first_time;

/**
 * @author ycc
 * @description
 * @date 2022/2/27
 */
public class LeetCode_50_递归_计算x的n次幂 {

    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : quickMul(1 / x, Math.abs(n));
    }

    /**
     * 注意需要使用快速求幂的方式进行递归，否则会导致内存溢出
     * 普通递归pow(x,n)=x*pow(x,n-1)
     * 快速递归pow(x,n)=pow(x,n/2) * pow(x,n/2) * x || pow(x,n)=pow(x,n/2) * pow(x,n/2)
     * @param x
     * @param n
     * @return
     */
    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

}
