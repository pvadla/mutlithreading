package com.example.multithreadingconcepts.callable;

import java.util.function.Supplier;

public class SupplierTest implements Supplier<String> {


    @Override
    public String get() {
        return "Data from supplier";
    }
}
