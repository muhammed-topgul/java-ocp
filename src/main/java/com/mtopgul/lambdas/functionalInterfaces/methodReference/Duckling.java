package com.mtopgul.lambdas.functionalInterfaces.methodReference;

/**
 * @author muhammed-topgul
 * @since 27/02/2024 07:46
 */
public class Duckling {
    public static void makeSound(String sound) {
        LearnToSpeak learner1 = (s) -> System.out.println(s);
        DuckHelper.teacher(sound, learner1);

        LearnToSpeak learner2 = System.out::println;
        DuckHelper.teacher(sound, learner2);

        LearnToSpeak learner3 = new LearnToSpeak() {
            @Override
            public void speak(String sound) {
                System.out.println(sound);
            }
        };

        DuckHelper.teacher(sound, learner3);
    }

    public static void main(String[] args) {
        makeSound("Java");
    }
}
