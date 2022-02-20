package com.ycc.huawei_questions;

import java.util.Scanner;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc TLV解码
 *
 * TLV编码是按 Tag Length  Value格式进行编码的
 *         一段码流中的信元用tag标识，tag在码流中唯一不重复
 *         length表示信元value的长度  value表示信元的值
 *         码流以某信元的tag开头 ，tag固定占一个字节
 *         length固定占两个字节，字节序为小端序
 *         现给定tlv格式编码的码流以及需要解码的信元tag
 *         请输出该信元的value
 *
 *         输入码流的16机制字符中，不包括小写字母
 *         且要求输出的16进制字符串中也不要包含字符字母
 *         码流字符串的最大长度不超过50000个字节
 *
 *         输入描述
 *            第一行为第一个字符串 ，表示待解码信元的tag
 *            输入第二行为一个字符串， 表示待解码的16进制码流
 *           字节之间用空格分割
 *         输出描述
 *            输出一个字符串，表示待解码信元以16进制表示的value
 *
 *            例子：
 *            输入：
 *             31
 *             32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 *
 *            输出
 *             32 33
 *
 *            说明：
 *            需要解析的信源的tag是31
 *            从码流的起始处开始匹配，tag为32的信元长度为1(01 00,小端序表示为1)
 *            第二个信元的tag为90 其长度为2
 *            第三个信元的tag为30 其长度为3
 *            第四个信元的tag为31 其长度为2(02 00)
 *            所以返回长度后面的两个字节即可 为 32 33
 */
public class TlvDecode_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tag = scanner.nextLine();
        String[] tlvStrs = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tlvStrs.length; ) {
            /**
             * 长度计算规则，将两个字节的长度标识位按照16进制转成十进制，需要注意小端序在前需要颠倒位置
             */
            int len = Integer.parseInt(tlvStrs[i + 2] + tlvStrs[i+1], 16);
            if (tag.equals(tlvStrs[i])) {
                for (int j = i + 3; j < i + 3 + len; j++) {
                    result.append(tlvStrs[j] + " ");
                }
            }
            i = i + len + 3;
        }
        System.out.println(result.toString().trim());
    }

}