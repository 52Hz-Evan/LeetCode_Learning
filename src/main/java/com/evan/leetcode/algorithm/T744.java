package com.evan.leetcode.algorithm;

import java.util.Arrays;

/**
 * @Author: Evan
 * @CreateTime: 2020-04-01
 * @Description: 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 */

public class T744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        if(letters.length<2){
            return '\0';
        }
        Arrays.sort(letters);

        if(target<letters[0]){
            return letters[0];
        }

        for (int i = 0; i < letters.length; i++) {
            if(letters[i]==target){
                if(i<letters.length&&letters[i+1]>=target){
                    if(letters[i]!=letters[i+1]){
                        return letters[i+1];
                    }
                }
            }

            if(letters[i]<target){
                if(i<letters.length&&letters[i+1]>target){
                    return letters[i+1];
                }
            }

            if(i==letters.length-2&&letters[i+1]<=target){
                return letters[0];
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
//        char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        char[] letters = {'c','f','j'};
        char result = nextGreatestLetter(letters,'c');
        System.out.print(result);
    }
}
