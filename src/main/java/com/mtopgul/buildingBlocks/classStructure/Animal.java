package com.mtopgul.buildingBlocks.classStructure;

/**
 * @author muhammed-topgul
 * @since 02/01/2024 08:18
 */
public class Animal {
    private String name;

    // comment until end of line
    /* Multiple
     * line comment
     */
    public String getName() {
        return name;
    }

    /**
     * Javadoc multiple-line comment
     * @param newName
     */
    public void setName(String newName) {
        name = newName;
    }
}

class Animal2 {

}
