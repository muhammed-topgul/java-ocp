package com.mtopgul.collectionsAndGenerics.generics.typeErasure;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 12:51
 */
public class CrateV2<T> {
    private T contents;

    public T lookInCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}
