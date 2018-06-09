package com.mufeng.stacks;

import java.util.Stack;

/**
 * Created by wb-yxk397023 on 2018/6/9.
 */
// 括号匹配
public class Solution {

    public boolean isValid(String s){

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }

                Character popChar = stack.pop();

                if (c == ')' && popChar != '('){
                    return false;
                }
                if (c == ']' && popChar != '['){
                    return false;
                }
                if (c == '}' && popChar != '{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution().isValid("([)]")));
    }
}
