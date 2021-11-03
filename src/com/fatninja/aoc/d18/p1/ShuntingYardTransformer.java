package com.fatninja.aoc.d18.p1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ShuntingYardTransformer {

    public static String transform(String formula) {
        char[] chars = formula.toCharArray();

        Queue<Character> outputQueue = new ArrayDeque<>();
        Stack<Character> operatorStack = new Stack<>();

        for (char c : chars) {
            if (c == ' ') {
                continue;
            }

            if (isNumeric(c)) {
                outputQueue.add(c);
            } else if (isOperator(c)) {
                //this is the only line different from P2
                if (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    outputQueue.add(operatorStack.pop());
                }
                operatorStack.add(c);
            } else if (c == '(') {
                operatorStack.add(c);
            } else {
                char top = operatorStack.pop();
                while (top != '(') {
                    outputQueue.add(top);
                    top = operatorStack.pop();
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop());
        }

        return getStringValue(outputQueue);
    }

    private static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '*';
    }

    private static String getStringValue(Queue<Character> queue) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append(queue.remove());
        }

        return stringBuilder.toString();
    }
}
