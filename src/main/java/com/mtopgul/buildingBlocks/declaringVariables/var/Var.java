package com.mtopgul.buildingBlocks.declaringVariables.var;

/**
 * @author muhammed-topgul
 * @since 11/01/2024 08:49
 */
public class Var {
    public void var() {
        var var = "var";
        int a = 10, b = 20, c = 30;
        // var d = 40, e = 50, f = 60; // DOES NOT COMPILE
    }

    public void Var() {
        Var var = new Var();
    }
}
