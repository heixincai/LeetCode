package com.syd.leetcode.algorithm;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseInt {
    public static int reverse(int x){
        int y = 0 ;
        while(x != 0){
            //每次取末尾数字
            int temp = x % 10;
            //判断是否 大于 最大32位整数
            if (y > 214748364 || (y == 214748364 && temp > 7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (y <- 214748364 || ( y == -214748364 && temp < -8)) {
                return 0;
            }
            y = y * 10 + temp;
            x /= 10;
        }
        return y;
    }

    public static void main(String[] args) {
        int a = -2147483648;
        System.out.println(reverse(a));
    }
}
