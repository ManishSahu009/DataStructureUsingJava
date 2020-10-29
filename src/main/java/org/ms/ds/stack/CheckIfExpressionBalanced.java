package org.ms.ds.stack;
/*
https://www.techiedelight.com/check-given-expression-balanced-expression-not/

 */

import java.util.Stack;

public class CheckIfExpressionBalanced {

    public static boolean balParenthesis(String exp)
    {

        if (exp.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch: exp.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            }
            else if (ch == '{') {
                stack.push('}');
            }
            else if (ch == '[') {
                stack.push(']');
            }
            else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args)
    {
        String exp = "{()}[{}]";

        if (balParenthesis(exp)) {
            System.out.println("The expression is balanced");
        } else {
            System.out.println("The expression is not balanced");
        }
    }

}
