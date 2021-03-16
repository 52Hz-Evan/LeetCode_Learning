package com.leetcode.editor.offer;//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 86 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Offer05 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
