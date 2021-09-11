package com.fatninja.aoc.d8.p1;

import com.fatninja.aoc.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> instructions = FileUtils.readStringListFromFile("src/resources/d8/input.txt");
        boolean[] executed = new boolean[instructions.size()];
        int globalValue = 0;

        for (int step = 0; step < instructions.size(); step++) {
            if (executed[step]) {
                break;
            }
            executed[step] = true;

            String instruction = instructions.get(step);
            String verb = getInstructionVerb(instruction);
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

        System.out.println(globalValue);
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
