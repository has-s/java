import org.junit.Test;
import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void testAddAndGet() {
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(2);

        assertEquals(Integer.valueOf(1), container.get(0));
        assertEquals(Integer.valueOf(2), container.get(1));
    }

    @Test
    public void testRemove() {
        Container<String> container = new Container<>();
        container.add("A");
        container.add("B");
        container.add("C");

        container.remove(1);
        assertEquals(2, container.size());
        assertEquals("A", container.get(0));
        assertEquals("C", container.get(1));
    }

    @Test
    public void testSize() {
        Container<String> container = new Container<>();
        assertEquals(0, container.size());

        container.add("A");
        assertEquals(1, container.size());

        container.add("B");
        assertEquals(2, container.size());
    }

    @Test
    public void testIsEmpty() {
        Container<Double> container = new Container<>();
        assertTrue(container.isEmpty());

        container.add(3.14);
        assertFalse(container.isEmpty());

        container.remove(0);
        assertTrue(container.isEmpty());
    }
}
