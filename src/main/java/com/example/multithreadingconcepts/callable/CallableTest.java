package com.example.multithreadingconcepts.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTest implements Callable {


    @Override
    public String call() throws Exception {
        Random rand = new Random();
        Integer result = rand.nextInt(5);
        Thread.sleep(5000);
        return Thread.currentThread().getName();
    }
}
