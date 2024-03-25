package com.mtopgul.concurrency.introducingThread;

import com.mtopgul.Util;

/**
 * @author muhammed-topgul
 * @since 25/03/2024 18:05
 */
public class ThreadLifeCycle {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        Util.divide("mainThread");
        System.out.println(mainThread.getState());
        System.out.println(mainThread.isAlive());


        Util.divide("Before thread.start()");
        Thread thread = new Thread(() -> System.out.println("Hello World!"));
        System.out.println(thread.getState());
        System.out.println(thread.isAlive());

        thread.start();;

        Util.divide("After thread.start()");
        System.out.println(thread.getState());
        System.out.println(thread.isAlive());
    }
}
