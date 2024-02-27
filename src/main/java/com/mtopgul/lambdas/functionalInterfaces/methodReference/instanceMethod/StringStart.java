package com.mtopgul.lambdas.functionalInterfaces.methodReference.instanceMethod;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 08:06
 */
@FunctionalInterface
public interface StringStart {
    boolean beginningCheck(String prefix);

    static void main(String[] args) {
        var str = "Zoo";
        StringStart methodRef = str::startsWith;
        StringStart lambda = s -> str.startsWith(s);


        Checker zoo = new Checker("Zoo");
        StringStart methodRef1 = zoo::startsWith;
        StringStart lambda1 = s -> zoo.startsWith(s);

        System.out.println(methodRef.beginningCheck("Z"));
    }
}

class Checker {
    private final String text;

    public Checker(String text) {
        this.text = text;
    }

    public boolean startsWith(String prefix) {
        return text.startsWith(prefix);
    }
}
