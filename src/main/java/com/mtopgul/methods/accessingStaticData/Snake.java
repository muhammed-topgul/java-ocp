package com.mtopgul.methods.accessingStaticData;

/**
 * @author muhammed-topgul
 * @since 02/02/2024 10:55
 */
public class Snake {
     static long hiss = 2;

    public static void main(String[] args) {
        System.out.println(Snake.hiss);
        Snake snake = new Snake();
        System.out.println(snake.hiss);
        snake = null;
        System.out.println(snake.hiss);
    }
}
