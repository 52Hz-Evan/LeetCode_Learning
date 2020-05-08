package com.leetcode.editor.cn;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索


import com.leetcode.editor.cn.config.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T98{

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(6);
        System.out.println(isValidBST(root));
    }


    public static boolean isValidBST(TreeNode root) {
        if (null == root ||(root.left==null&&root.right==null)) {
            return true;
        }
        List<Integer> list = new ArrayList();
        List<Integer> result = centerSort(root, list);
        for (int i = 0; i < result.size()-1; i++) {
            if (result.get(i) >= result.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static List centerSort(TreeNode treeNode,List<Integer> list) {

        if(treeNode.left!=null){
            centerSort(treeNode.left, list);
        }
        list.add(treeNode.val);
        if(treeNode.right!=null){
            centerSort(treeNode.right, list);
        }
        return list;
    }

}