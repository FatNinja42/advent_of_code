package com.fatninja.aoc.d18;

import java.util.Stack;

public class PostfixNotationExpressionSolver {

    public static long solve(String expression) {
        String a;
        String b;
        String operation;
        long result;

        Stack<String> operationsStack = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char c : chars) {
            operationsStack.add(String.valueOf(c));

            String peek = operationsStack.peek();
            if (isOperation(peek)) {
                operation = operationsStack.pop();
                b = operationsStack.pop();
                a = operationsStack.pop();

                result = doOperation(Long.parseLong(a), Long.parseLong(b), operation);
                operationsStack.add(String.valueOf(result));
            }
        }

        return Long.parseLong(operationsStack.pop());
    }

    private static boolean isOperation(String character) {
        return character.equals("+") || character.equals("*");
    }

    private static long doOperation(long a, long b, String operation) {
        if (operation.equals("+")) {
            return a + b;
        }
        return a * b;

    }
}
