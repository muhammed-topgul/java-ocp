package com.mtopgul.concurrency.concurrencyApi.callable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author muhammed-topgul
 * @since 26/03/2024 08:16
 */
public class CallableExample01 {
    public static void main(String[] args) throws Exception {
        var executorService = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> result = executorService.submit(() -> 30 + 11);
            System.out.println("get(): " + result.get());
            System.out.println("isDone(): " + result.isDone());
            System.out.println("isCancelled(): " + result.isCancelled());
        } finally {
            executorService.shutdown();
        }
    }
}
