package com.mtopgul.exceptionsAndLocalization.handling;

/**
 * @author muhammed-topgul
 * @since 19/03/2024 14:23
 */
public class MultiCacheBlock {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new ParentException();
            } else {
                throw new MyException();
            }
        } catch (ParentException | MyException | RtException e) {

        }
    }
}

class ParentException extends Exception {
}

class ChildException extends ParentException {
}

class MyException extends Exception {
}

class RtException extends RuntimeException {
}