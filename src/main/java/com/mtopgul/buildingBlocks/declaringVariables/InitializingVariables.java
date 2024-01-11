package com.mtopgul.buildingBlocks.declaringVariables;

/**
 * @author muhammed-topgul
 * @since 11/01/2024 08:34
 */
public class InitializingVariables {
    public int valid() {
        int y = 10;
        int x; // x is declared here
        x = 3; // x is initialized here
        int z; // z is declared here but never initialized or used
        int reply = x + y;
        return reply;
    }

    public void findAnswer(boolean check) {
        int answer;
        int otherAnswer;
        int onlyOneBranch;
        if (check) {
            onlyOneBranch = 1;
            answer = 1;
        } else {
            answer = 2;
        }
        System.out.println(answer);
        // System.out.println(onlyOneBranch); // DOES NOT COMPILE
    }
}
