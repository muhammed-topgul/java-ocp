package com.mtopgul.coreApis.stringBuilder;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 10:19
 */
public class InsertingData {
    public static void main(String[] args) {
        var sb = new StringBuilder("animals");
        sb.insert(0, "-"); // -animals
        sb.insert(8, "-"); // -animals-
        sb.insert(4, "-"); // -ani-mals-

        // sb.insert(-1, "*"); // StringIndexOutOfBoundsException
        // sb.insert(12, "*"); // StringIndexOutOfBoundsException
        System.out.println(sb);
    }
}
