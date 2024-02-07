package com.mtopgul.classDesign.inheritingMembers;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author muhammed-topgul
 * @since 07/02/2024 09:30
 */
public class GalapagosTortoise extends Reptile {
    @Override
    protected void sleep() throws FileNotFoundException {
    }

    // protected void sleep() throws Exception {} // DOES NOT COMPILE

    // protected void hide() throws FileNotFoundException {} // DOES NOT COMPILE

    @Override
    protected void hide() throws NullPointerException {
        super.hide();
    }

    // protected void exitShell() throws IOException {} // DOES NOT COMPILE


    @Override
    protected void speak() throws RuntimeException {
        super.speak();
    }
}
