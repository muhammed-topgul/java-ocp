package com.mtopgul.collectionsAndGenerics.generics.creating;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 10:44
 */
public class Crate<T> {
    private T contents;

    public T lookInCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }
}
