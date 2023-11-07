package org.example;

import java.util.*;
import java.util.regex.*;

/**
 * Класс, выполняющий вычисление математических выражений.
 */
public class MathExpressionEvaluator {
    private Map<String, Double> variables;

    /**
     * Конструктор класса.
     */
    public MathExpressionEvaluator() {
        variables = new HashMap<>();
    }

    /**
     * Добавить переменную и ее значение.
     * @param variableName Имя переменной.
     * @param value Значение переменной.
     */
    public void addVariable(String variableName, double value) {
        variables.put(variableName, value);
    }

    /**
     * Вычислить значение выражения.
     * @param expression Выражение для вычисления.
     * @return Результат вычисления или NaN в случае ошибки.
     */
    public double evaluateExpression(String expression) {
        try {
            // Заменяем имена переменных на их значения
            for (Map.Entry<String, Double> entry : variables.entrySet()) {
                expression = expression.replaceAll(Pattern.quote(entry.getKey()), entry.getValue().toString());
            }

            // Вычисляем выражение с использованием JavaScript Engine
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            Object result = engine.eval(expression);

            if (result instanceof Number) {
                return ((Number) result).doubleValue();
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        return Double.NaN; // В случае ошибки возвращаем NaN
    }

    public static void main(String[] args) {
        MathExpressionEvaluator evaluator = new MathExpressionEvaluator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение:");
        String expression = scanner.nextLine();

        // Запрос значений переменных у пользователя
        for (String variable : expression.split("[+\\-*/() ]+")) {
            if (!variable.isEmpty() && !variable.matches("\\d+(\\.\\d+)?")) {
                System.out.print("Введите значение для переменной " + variable + ": ");
                double value = scanner.nextDouble();
                evaluator.addVariable(variable, value);
            }
        }

        double result = evaluator.evaluateExpression(expression);
        if (!Double.isNaN(result)) {
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Ошибка при вычислении выражения.");
        }
    }
}
