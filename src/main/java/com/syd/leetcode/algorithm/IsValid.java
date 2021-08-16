package com.syd.leetcode.algorithm;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {

    /**
     * 思路：
     * 1.遍历str，如果是左括号，则放入栈中，如：{
     * 2.依次获取str的后面字符，如果是右括号，如：}，若与栈中字符匹配，将栈用元素移除：{
     * 3.判断栈是否为空，或者如果有括号匹配stack最后一个符号不满足，也是false。
     */
    public boolean isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c=='('){
                stack.push(')');
            } else if(c=='[') {
                stack.push(']');
            } else if(c=='{') {
                stack.push('}');
            } else if(stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 1.将所有右括号进放入map，value对应左括号。
     * 2.遍历String s，如果map中keys包含，则说明是有括号，从stack中pop最后一个左括号进行比较。
     * 如果map中keys不包含，则说明是左括号，放入stack中即可。
     * 3.如果stack为空，说明stack中的左括号被匹配完毕，结果验证成功。
     */
    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String str = "}{";
        System.out.println("结果：" + isValid.isValid(str));
    }

}
