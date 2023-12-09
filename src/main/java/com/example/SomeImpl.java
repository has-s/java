package com.example;

/**
 * Реализация интерфейса SomeInterface, которая выводит "A", когда вызывается doSomething().
 */
public class SomeImpl implements SomeInterface {
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}