package com.mtopgul.coreApis.stringBuilder;

/**
 * @author muhammed-topgul
 * @since 30/01/2024 10:22
 */
public class DeleteContents {
    public static void main(String[] args) {
        var sb = new StringBuilder("abcdef");
        sb.delete(1, 3);           // adef
        // sb.delete(5, 8);        // StringIndexOutOfBoundsException
        sb.delete(4, 8000);        // adef
        sb.delete(2, 10000);       // ad

        sb.deleteCharAt(1); // a
        sb.deleteCharAt(3); // StringIndexOutOfBoundsException

        System.out.println(sb);
    }
}
