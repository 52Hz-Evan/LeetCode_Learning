package com.leetcode.editor.cn.config;

/**
 * @Author: Evan
 * @CreateTime: 2020-07-10
 * @Description:
 */
public class MountainArrayImpl implements MountainArray {
    @Override
    public int get(int index) {
        int[] array = {1,2,3,4,5,3,1};
        return array[index];
    }

    @Override
    public int length() {
        return 0;
    }
}
