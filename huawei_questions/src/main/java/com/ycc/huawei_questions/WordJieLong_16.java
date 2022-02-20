package com.ycc.huawei_questions;

import java.util.*;

/**
 * @author ycc
 * @date 2022/2/19
 * @desc  单词接龙  后一个字符串前缀是前一个字符串后缀
 * 单词接龙的规则是
 *         可用于接龙的单词 首字母必须要与前一个单词的尾字母相同
 *         当存在多个首字母相同的单词时，取长度最长的单词
 *         如果长度也相等，则取字典序最小的单词
 *         已经参与接龙的单词不能重复使用
 *         现给定一组全部由小写字母组成的单词数组
 *         并指定其中一个单词为起始单词
 *         进行单词接龙
 *         请输出最长的单词串
 *         单词串是单词拼接而成的中间没有空格
 *
 *         输入描述
 *         输入第一行为一个非负整数
 *         表示起始单词在数组中的索引k
 *         0<=k<N
 *         输入的第二行为非负整数N
 *         接下来的N行分别表示单词数组中的单词
 *
 *         输出描述，
 *         输出一个字符串表示最终拼接的单词串
 *
 *         示例
 *         0
 *         6
 *         word
 *         dd
 *         da
 *         dc
 *         dword
 *         d
 *
 *         输出
 *         worddwordda
 *         说明 先确定起始单词word 在接dword
 *         剩余dd da dc 则取da
 *
 *        示例2
 *         4
 *         6
 *         word
 *         dd
 *         da
 *         dc
 *         dword
 *         d
 *
 *         输出
 *         dwordda
 *
 *         单词个数1<N<20
 *         单个单词的长度  1~30
 */
public class WordJieLong_16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        List<String> strs = new ArrayList<>(size);
        Map<Character,List<String>> cacheMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String str = scanner.nextLine();
            strs.add(str);
            if (i == start) {
                continue;
            }
            Character startStr = str.charAt(0);
            if (cacheMap.containsKey(startStr)) {
                cacheMap.get(startStr).add(str);
            } else {
                List<String> list = new LinkedList<>();
                list.add(str);
                cacheMap.put(startStr, list);
            }
        }
        for (Character key : cacheMap.keySet()) {
            Collections.sort(cacheMap.get(key), new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        for (int i = 1; i < o1.length(); i++) {
                            if (o1.charAt(i) != o2.charAt(i)) {
                                return o1.charAt(i) - o2.charAt(i);
                            }
                        }
                        return 0;
                    } else {
                        return o2.length() - o1.length();
                    }
                }
            });
        }
        String firstWord = strs.get(start);
        StringBuilder result = new StringBuilder(firstWord);
        Character key = firstWord.charAt(firstWord.length() - 1);
        while (cacheMap.containsKey(key)) {
            String tmp = cacheMap.get(key).get(0);
            result.append(tmp);
            cacheMap.get(key).remove(0);
            key = tmp.charAt(tmp.length() - 1);
        }
        System.out.println(result.toString());
    }

}
