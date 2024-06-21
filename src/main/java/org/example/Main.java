package org.example;

import org.example.service.Service;
import org.example.annotations.LogExecutionTime;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) throws Exception {
        Service service = new Service();
        Method method = service.getClass().getMethod("serve");

        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            long start = System.currentTimeMillis();
            method.invoke(service);
            long end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end - start) + "ms");
        } else {
            method.invoke(service);
        }
    }
}
