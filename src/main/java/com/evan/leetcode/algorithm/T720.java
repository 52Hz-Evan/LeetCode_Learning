package com.evan.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Evan
 * @CreateTime: 2020-04-01
 * @Description: 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 */
public class T720 {
    public static String longestWord(String[] words) {
        List<String> wordlist = new ArrayList<>();

        for (String word: words){
            wordlist.add(word);
        }

        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };

        Arrays.sort(words,cmp);


        String target = "";

        for (String word: words) {
            boolean isIdea = true;
            if(word.length() > target.length() ||
                    word.length() == target.length() && word.compareTo(target) < 0){
                for (int i = 1; i < word.length()+1; i++) {
                    int finalI = i;
                    boolean isB = wordlist.stream().anyMatch(w -> w.equals(word.substring(0, finalI)));
                    if(!isB){
                        isIdea = false;
                        break;
                    }
                }
                if(isIdea){
                    target = word;;
                }
            }
        }
        return target;
    }

    public static void main(String[] args) {
        String[] words = {};
        String word = longestWord(words);
        System.out.println(word);
    }
}
