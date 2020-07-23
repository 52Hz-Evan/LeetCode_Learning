package com.leetcode.learn.sort;

import java.util.Arrays;

/**
 * @Author: Evan
 * @CreateTime: 2020-07-23
 * @Description: 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        //初始化需要排序的数组
        int[] array = {9, 2, 11, 7, 12, 5};

        //初始化一个与待排序数组大小相同的数组，用来存放排序好的序列
        int[] sortArray = new int[array.length];

        //步骤1：待排序数组中选择第一个元素作为已经排序好的元素（数组的下标0表示第一个元素）
        sortArray[0] = array[0];

        //步骤2：依次遍历未排序的元素，将其插入已排序序列中
        for (int i = 1; i < array.length; i++) {
            //待排序元素
            int temp = array[i];
            //记录待排序元素需要插入已排序数组中的位置
            int index = i;
            //从已排序好的数组右边依次遍历数组，直到找到待排序元素需要插入的位置\
            int sortInt = sortArray[index-1];
            while(  index > 0  && temp < sortInt ){
                sortArray[index] = sortArray[index-1];
                index--;
            }
            //插入待排序元素
            sortArray[index] = temp;
        }

        //打印出排序好的序列
        System.out.println(Arrays.toString(sortArray));
    }
}
