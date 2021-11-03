package com.fatninja.aoc.d18.p2;

import com.fatninja.aoc.d18.PostfixNotationExpressionSolver;
import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> formulae = FileUtils.readStringListFromFile("src/resources/d18/input.txt");
        long sum = 0;

        for (String formula : formulae) {
            String expression = ShuntingYardTransformer.transform(formula);
            sum += PostfixNotationExpressionSolver.solve(expression);
        }

        System.out.println(sum);
    }
}