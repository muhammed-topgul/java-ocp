package com.mtopgul.buildingBlocks.declaringVariables;

/**
 * @author muhammed-topgul
 * @since 11/01/2024 08:42
 */
public class VarType {
    // var tricky = "Hello"; // DOES NOT COMPILE

    public void whatTypeAmI() {
        var name = "Hello";
        var size = 7;
    }

    public void reassignment() {
        var number = 7;
        number = 4;
        // number = "five"; // DOES NOT COMPILE
    }

    public void breakingDeclaration() {
        var silly
                = 1;
    }

    public void doesThisCompile(boolean check) {
        // var question;  // DOES NOT COMPILE
        // question = 1;
        // var answer;    // DOES NOT COMPILE
        // if (check) {
        //     answer = 2;
        // } else {
        //     answer = 3;
        // }
        // System.out.println(answer);
    }

    public void twoTypes() {
        // int a, var b = 3; // DOES NOT COMPILE
        // var b = null; // DOES NOT COMPILE
        var c = (String) null;
    }
}
