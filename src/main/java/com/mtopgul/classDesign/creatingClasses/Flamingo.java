package com.mtopgul.classDesign.creatingClasses;

/**
 * @author muhammed-topgul
 * @since 05/02/2024 08:45
 */
public class Flamingo {
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        var f = new Flamingo();
        f.setColor("pink");
        System.out.println(f.color);
    }
}
