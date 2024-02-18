package com.mtopgul.beyondClasses.nestedClasses.innerClass;

/**
 * @author muhammed-topgul
 * @since 18/02/2024 23:20
 */
public class A {
    private int x = 10;

    class B {
        private int x = 20;

        class C {
            private int x = 30;

            public void allTheX() {
                System.out.println(x);        // 30
                System.out.println(this.x);   // 30
                System.out.println(B.this.x); // 20
                System.out.println(A.this.x); // 10
            }
        }
    }

    public static void main(String[] args) {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = a.new B().new C();
        c.allTheX();
    }
}
