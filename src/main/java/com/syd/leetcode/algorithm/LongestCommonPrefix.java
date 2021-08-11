package com.syd.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    /**
     * 标签：链表
     * 当字符串数组长度为 0 时则公共前缀为空，直接返回
     * 令最长公共前缀 ans 的值为第一个字符串，进行初始化
     * 遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
     * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
     * 时间复杂度：O(s)O(s)，s 为所有字符串的长度之和
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String tempStr = strs[0];
        for(int i = 1 ; i < strs.length ; i ++ ) {
            int j = 0;
            for(; j < tempStr.length() && j < strs[i].length(); j ++) {
                if(strs[i].charAt(j) != tempStr.charAt(j)) {
                    break;
                }
            }
            tempStr = tempStr.substring(0,j);
            if("".equals(tempStr)){
                return tempStr;
            }
        }
        return tempStr;
    }

    /**
     * 取一个单词 s，和后面单词比较，看 s 与每个单词相同的最长前缀是多少！遍历所有单词。
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String res = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i += 1;
        }
        return res;
    }

    /**
     * 按字典排序数组，比较第一个，和最后一个单词，有多少前缀相同。
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        // 字符串转数组
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (i < b.length && a[i] == b[i]) {
                res.append(a[i]);
            } else{
                break;
            }
        }
        return res.toString();

    }


    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        String str = longestCommonPrefix(strs);
        String str2 = longestCommonPrefix2(strs);
        String str3 = longestCommonPrefix3(strs);
        System.out.println(str + ";" + str2 + ";" + str3);
    }

}
