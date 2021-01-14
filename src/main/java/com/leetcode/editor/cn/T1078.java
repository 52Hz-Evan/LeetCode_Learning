package com.leetcode.editor.cn;

//给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 se
//cond 紧随 first 出现，third 紧随 second 出现。 
//
// 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：text = "alice is a good girl she is a good student", first = "a", second =
// "good"
//输出：["girl","student"]
// 
//
// 示例 2： 
//
// 输入：text = "we will we will rock you", first = "we", second = "will"
//输出：["we","rock"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成 
// 1 <= first.length, second.length <= 10 
// first 和 second 由小写英文字母组成 
// 
// Related Topics 哈希表


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class T1078{
    public static void main(String[] args) {
        String[] result = findOcurrences("alice is a good girl she is a good student", "a", "good");
        System.out.println(JSON.toJSON(result));
    }

    public static String[] findOcurrences(String text, String first, String second) {
        List<String> strs = new ArrayList<>();
        String[] split = text.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(first) && i+2 < split.length) {
                if (split[i+1].equals(second)) {
                    strs.add(split[i+2]);
                }
            }
        }

        return strs.toArray(new String[strs.size()]);
    }
}