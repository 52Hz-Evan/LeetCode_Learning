package com.leetcode.editor.offer;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.editor.cn.config.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Offer06 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(3);
        node.next = node1;
        ListNode node2 = new ListNode(2);
        node.next.next = node2;
        reversePrint(node);

    }
    public static int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};
        int len = 0;
        List<Integer> arr = new ArrayList<>();
        while(head.next != null) {
            len++;
            arr.add(head.val);
            head = head.next;
        }
        len++;
        arr.add(head.val);
        int[] result = new int[len];
        int index = 0;
        for (int i = len-1; i >= 0; i--) {
            result[index] = arr.get(i);
            index++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
