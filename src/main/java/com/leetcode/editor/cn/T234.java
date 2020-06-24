package com.leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


import com.alibaba.fastjson.JSON;
import com.leetcode.editor.cn.config.ListNode;

import java.util.ArrayList;
import java.util.List;

public class T234{
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(l1));
    }

    public static boolean isPalindrome(ListNode head) {
        if(null == head) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while(head.next != null) {
            list.add(head.val);
            head = head.next;
            System.out.println(JSON.toJSON(list));
        }
        list.add(head.val);
        for (int i = 0; i < list.size()/2; i++) {
            if (!list.get(i).equals(list.get(list.size()-i-1))){
                return false;
            }
        }
        return true;
    }
}
