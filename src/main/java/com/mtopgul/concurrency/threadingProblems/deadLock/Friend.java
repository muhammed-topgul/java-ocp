package com.mtopgul.concurrency.threadingProblems.deadLock;

/**
 * @author muhammed-topgul
 * @since 29/03/2024 08:07
 */
public record Friend(String name) {
    public synchronized void bow(Friend bower) {
        System.out.printf("%s: %s has bowed to me\n", this.name, bower.name());
        bower.bowBack(this);
    }

    public synchronized void bowBack(Friend bower) {
        System.out.printf("%s: %s has bowed back to me", this.name, bower.name());
    }

    public static void main(String[] args) {
        Friend alphonse = new Friend("Alphonse");
        Friend gaston = new Friend("Gaston");

        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}
