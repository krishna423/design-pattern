package com.example.designpattern.logics.Coding;

import java.util.Stack;

public class ValidateParenthesis {

    static boolean validateParenthesis(String str){

        Stack<Character> stack = new Stack<>();
        Character ch;
        for(int i=0;i<str.length();i++){
            ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else {
                if (stack.empty()) {
                    return false;
                }
                Character stack_ch = stack.pop();
                if ((ch == ')' && stack_ch != '(')
                        || (ch == '}' && stack_ch != '{')
                        || (ch == ']' && stack_ch != '[')) {
                    return false;
                }

            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validateParenthesis("{()}[]"));
        System.out.println(validateParenthesis("{()}[]{"));
        System.out.println(validateParenthesis("{()}[]}"));


    }
}
