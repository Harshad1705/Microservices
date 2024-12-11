package com.java.c02_functional_interface;

import java.time.LocalDateTime;
import java.util.function.Supplier;

class SupplierImpl implements Supplier<LocalDateTime> {

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
    
}

class SupplierDemo {

    public static void main(String[] args) {
        
        Supplier<LocalDateTime> supplier = new SupplierImpl();
        System.out.println(supplier.get());

        Supplier<LocalDateTime> supplierLmbd = () -> LocalDateTime.now();
        System.out.println(supplierLmbd.get());

    }
    
}
