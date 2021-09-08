package com.fatninja.aoc.d8.p2;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> instructions = FileUtils.readStringListFromFile("src/resources/d8/p1/input.txt");
        int globalValue;
        boolean infiniteLoop;
        boolean[] executed;

        for (int j = 0; j < instructions.size(); j++) {
            globalValue = 0;
            infiniteLoop = false;
            executed = new boolean[instructions.size()];

            for (int step = 0; step < instructions.size(); step++) {
                if (executed[step]) {
                    infiniteLoop = true;
                    break;
                }
                executed[step] = true;

                String instruction = instructions.get(step);
                String verb = getInstructionVerb(instruction);

                if (step == j) {
                    if (verb.contains("nop")) {
                        verb = "jmp";
                    } else if (verb.contains("jmp")) {
                        verb = "nop";
                    }
                }
                if (verb.equalsIgnoreCase("nop")) {
                    continue;
                }

                int instructionValue = getInstructionValue(instruction);
                if (verb.equalsIgnoreCase("acc")) {
                    globalValue += instructionValue;
                } else {
                    step += instructionValue;
                    step--;
                }
            }
            if (!infiniteLoop) {
                System.out.println(globalValue);
                break;
            }
        }
    }

    private static String getInstructionVerb(String instruction) {
        return instruction.split(" ")[0];
    }

    private static int getInstructionValue(String instruction) {
        String[] components = instruction.split(" ");
        char sign = components[1].charAt(0);

        return Integer.parseInt(components[1].substring(1)) * (sign == '+' ? 1 : -1);
    }
}

