package com.ycc.study_first_time;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangBingYan
 * @date 2022/2/18
 * @description LeetCode 第一题 两数之和
 *
 * 采用Hash表对中间数据进行缓存，达到遍历一遍即可计算出结果的效果
 *
 */
public class LeetCode_01_哈希表_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cacheMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cacheMap.containsKey(target - nums[i])) {
                return new int[]{cacheMap.get(target - nums[i]), i};
            } else {
                cacheMap.put(nums[i], i);
            }
        }
        return null;
    }

}
