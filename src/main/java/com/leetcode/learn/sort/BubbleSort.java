package com.leetcode.learn.sort;

import java.util.Arrays;

/**
 * @Author: Evan
 * @CreateTime: 2020-07-23
 * @Description: 冒泡排序：O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {9,2,11,7,12,5,54,57,84,12,43,23};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i+1; j < array.length; j++) {
//                if (array[i] > array[j]) {
//                    int temp = array[j];
//                    array[j] = array[i];
//                    array[i] = temp;
//                }
//            }
//        }
        System.out.println(Arrays.toString(array));
    }
}
