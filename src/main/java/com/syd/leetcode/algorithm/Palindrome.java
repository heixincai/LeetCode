package com.syd.leetcode.algorithm;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {
    public static boolean isPalindrome(int value){
        if(value < 0){
            return false;
        }
        int y = 0;
        int x = value;
        while (x != 0) {
            int temp = x % 10;
            y = y * 10 + temp;
            if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
                return false;
            }
            x /= 10;
        }
        if(value == y){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = -969;
        System.out.println(isPalindrome(a));
    }
}