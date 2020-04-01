package com.evan.leetcode.algorithm;

/**
 * @Author: Evan
 * @CreateTime: 2020-04-01
 * @Description: 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 */
public class T746 {

    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==0){
            return 0;
        }
        if(cost.length==1){
            return cost[0];
        }
        int f0 = cost[0];
        int f1 = cost[1];

        int result = f1;
        for(int i=2;i<cost.length;i++){
            result=Math.min(cost[i]+f0,f1+cost[i]);
            f0=f1;
            f1=result;
        }

        return Math.min(f0,f1);
    }

    public static void main(String[] args) {
        int[] cost = {0,2,2,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
