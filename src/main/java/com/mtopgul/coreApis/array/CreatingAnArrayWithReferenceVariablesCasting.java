package com.mtopgul.coreApis.array;

/**
 * @author muhammed-topgul
 * @since 31/01/2024 07:38
 */
public class CreatingAnArrayWithReferenceVariablesCasting {
    public static void main(String[] args) {
        {
            String[] strings = {"stringValue"};
            Object[] objects = strings;
            String[] againStrings = (String[]) objects;
            // againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
            objects[0] = new StringBuilder();      // ArrayStoreException
        }
        {
            CharSequence[] chars = new CharSequence[1];
            chars[0] = new String("string Value");
            Object[] objects = chars;
            String[] strings = (String[]) chars; // ClassCastException
            objects[0] = "java";
            objects[0] = new StringBuilder("Ok");
        }
    }
}
