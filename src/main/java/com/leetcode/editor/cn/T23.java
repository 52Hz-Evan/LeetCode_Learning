package com.leetcode.editor.cn;

//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


import com.leetcode.editor.cn.config.ListNode;

import java.util.Arrays;

public class T23{
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        lists[0] = l1;


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        lists[1] = l2;

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        lists[2] = l3;

        mergeKLists(lists);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public static ListNode mergeKLists(ListNode[] lists) {
        int count = 0;
        for (ListNode listNode : lists) {
            if(listNode!=null) {
                while (listNode.next != null) {
                    listNode = listNode.next;
                    count++;
                }
                count++;
            }
        }
        int[] list = new int[count];

        int nextNum = 0;
        int num = 0;
        for (ListNode listNode : lists) {
            ListNode listNode1 = listNode;
            if(listNode!=null){
                nextNum = num;
                while(listNode.next!=null){
                    listNode = listNode.next;
                    num++;
                }
                num++;

                for (int i = nextNum; i < num; i++) {
                    list[i] = listNode1.val;
                    listNode1 = listNode1.next;
                }
            }
        }

        Arrays.sort(list);

        if(list.length!=0){
            ListNode root = new ListNode(list[0]);
            ListNode other = root;
            for (int i = 1; i < list.length; i++) {
                ListNode temp1 = new ListNode(list[i]);
                other.next = temp1;
                other = temp1;
            }
            return root;
        }
        return null;
    }
}