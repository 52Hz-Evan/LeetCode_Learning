package com.leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找


import java.util.Arrays;

public class T74{
    public static void main(String[] args) {
        int[][] a = {{1}};
//        int[][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        searchMatrix(a, 1);
    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] a = matrix[i];
            int max = a[a.length-1];
            if (target <= max) {
                int index = Arrays.binarySearch(a, target);
                if (index >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}