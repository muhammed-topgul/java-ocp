package com.mtopgul.buildingBlocks.mainMethod;

/**
 * @author muhammed-topgul
 * @since 02/01/2024 09:09
 */
public class Zoo {
    public static final void main(final String[] args) {
        System.out.println("Hello World!");
        if (args.length == 2) {
            System.out.println(args[0]);
            System.out.println(args[1]);
        }
    }
}
