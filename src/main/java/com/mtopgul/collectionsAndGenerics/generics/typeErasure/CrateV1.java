package com.mtopgul.collectionsAndGenerics.generics.typeErasure;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 12:51
 */
public class CrateV1 {
    private Object contents;

    public Object lookInCrate() {
        return contents;
    }

    public void packCrate(Object contents) {
        this.contents = contents;
    }
}
