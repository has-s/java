import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathExpressionEvaluatorTest {

    @Test
    public void testExpressionEvaluation() {
        MathExpressionEvaluator evaluator = new MathExpressionEvaluator();
        evaluator.addVariable("x", 5.0);
        evaluator.addVariable("y", 3.0);

        // Тесты вычисления выражений
        assertEquals(8.0, evaluator.evaluateExpression("x + y"), 1e-5);
        assertEquals(2.0, evaluator.evaluateExpression("x - y"), 1e-5);
        assertEquals(15.0, evaluator.evaluateExpression("x * y"), 1e-5);
        assertEquals(1.66667, evaluator.evaluateExpression("x / y"), 1e-5);

        // Тест на некорректное выражение
        assertTrue(Double.isNaN(evaluator.evaluateExpression("x + z")));

        // Тест на пустое выражение
        assertTrue(Double.isNaN(evaluator.evaluateExpression("")));
    }
}
