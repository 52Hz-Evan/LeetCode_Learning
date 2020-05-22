package com.leetcode.editor.cn;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


import java.util.Arrays;

public class T169{
    public static void main(String[] args) {
        int[] array = {3,3,4};
        majorityElement(array);
    }
    
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        int temp = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == temp) {
                num++;
            } else {
                if (num > nums.length/2) {
                    return nums[i-1];
                } else {
                    temp = nums[i+1];
                }
            }
        }
        return temp;
    }
}