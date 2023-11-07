package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numIterations = 50000;

        // Тестируем ArrayList
        List<Integer> arrayList = new ArrayList<>();
        testCollection(arrayList, numIterations, "ArrayList");

        // Тестируем LinkedList
        List<Integer> linkedList = new LinkedList<>();
        testCollection(linkedList, numIterations, "LinkedList");
    }

    public static void testCollection(List<Integer> collection, int numIterations, String collectionName) {
        // Засекаем время начала
        long startTime = System.currentTimeMillis();

        // Выполняем операции
        for (int i = 0; i < numIterations; i++) {
            collection.add(i); // Метод add
        }

        // Засекаем время окончания
        long endTime = System.currentTimeMillis();

        // Выводим результаты
        System.out.println("Тестируем: " + collectionName);
        System.out.println("Метод add: " + numIterations + " раз, время выполнения: " + (endTime - startTime) + " мс");

        // Засекаем время начала для метода get
        startTime = System.currentTimeMillis();

        for (int i = 0; i < numIterations; i++) {
            collection.get(i); // Метод get
        }

        // Засекаем время окончания для метода get
        endTime = System.currentTimeMillis();

        // Выводим результаты для метода get
        System.out.println("Метод get: " + numIterations + " раз, время выполнения: " + (endTime - startTime) + " мс");

        // Засекаем время начала для метода remove
        startTime = System.currentTimeMillis();

        for (int i = 0; i < numIterations; i++) {
            collection.remove(0); // Метод remove (удаляем первый элемент)
        }

        // Засекаем время окончания для метода remove
        endTime = System.currentTimeMillis();

        // Выводим результаты для метода remove
        System.out.println("Метод remove: " + numIterations + " раз, время выполнения: " + (endTime - startTime) + " мс");
        System.out.println();
    }
}
