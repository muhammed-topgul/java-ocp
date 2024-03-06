package com.mtopgul.collectionsAndGenerics.generics.methods;

import com.mtopgul.collectionsAndGenerics.generics.interfaces.Robot;

/**
 * @author muhammed-topgul
 * @since 06/03/2024 15:35
 */
public class TrickyCrate<T> {
    public <T> T tricky(T t) {
        return t;
    }

    public static String createName() {
        TrickyCrate<Robot> crate = new TrickyCrate<>();
        return crate.tricky("Java");
    }
}
