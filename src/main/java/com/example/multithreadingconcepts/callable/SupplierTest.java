package com.example.multithreadingconcepts.callable;

import java.util.function.Supplier;

public class SupplierTest implements Supplier<String> {


    @Override
    public String get() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return "Data from supplier: "+ Thread.currentThread().getName();
    }
}
