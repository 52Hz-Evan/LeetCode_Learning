package com.leetcode.editor.cn;

//在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一： 
//
// 
// "G"：直走 1 个单位 
// "L"：左转 90 度 
// "R"：右转 90 度 
// 
//
// 机器人按顺序执行指令 instructions，并一直重复它们。 
//
// 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 输入："GGLLGG"
//输出：true
//解释：
//机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
//重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
// 
//
// 示例 2： 
//
// 输入："GG"
//输出：false
//解释：
//机器人无限向北移动。
// 
//
// 示例 3： 
//
// 输入："GL"
//输出：true
//解释：
//机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。 
//
// 
//
// 提示： 
//
// 
// 1 <= instructions.length <= 100 
// instructions[i] 在 {'G', 'L', 'R'} 中 
// 
// Related Topics 数学


public class T1041 {

    public static void main(String[] args) {
        boolean result = isRobotBounded("RRGRRGLLLRLGGLGLLGRLRLGLRLRRGLGGLLRRRLRLRLLGRGLGRRRGRLG");
        System.out.println(result);
    }


    public static boolean isRobotBounded(String instructions) {
        //0:北；1：南；2：西；3：东。
        int d = 0;
        int x = 0;
        int y = 0;
        char temp;
        for (int i = 0; i < instructions.length(); i++) {
            temp = instructions.charAt(i);
            if (temp == 'G') {
                if (d == 0) {
                    y++;
                } else if (d == 1) {
                    y--;
                } else if (d == 2) {
                    x--;
                } else if (d == 3) {
                    x++;
                }
            } else if (temp == 'R') {
                if (d == 0) {
                    d = 2;
                } else if (d == 1) {
                    d = 3;
                } else if (d == 2) {
                    d = 1;
                } else if (d == 3) {
                    d = 0;
                }
            } else if (temp == 'L') {
                if (d == 0) {
                    d = 3;
                } else if (d == 1) {
                    d = 2;
                } else if (d == 2) {
                    d = 0;
                } else if (d == 3) {
                    d = 1;
                }
            }
        }

        if (x == 0 && y == 0) {
            return true;
        }
        if (d != 0) {
            return true;
        }
        return false;
    }
}