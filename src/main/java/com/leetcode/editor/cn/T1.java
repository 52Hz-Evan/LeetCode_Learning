package com.leetcode.editor.cn;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


import org.junit.Test;

import java.util.Arrays;

public class T1{
    @Test
    public void test() {
        int[] nums = {0,3,-3,4,-1};
        int target = -1;
        int[] result = twoSum(nums,target);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int numOne = nums[i];
            int numOther = target-numOne;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j]==numOther&&j!=i){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

}