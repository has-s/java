/**
 * Класс Container представляет собой контейнер для хранения элементов обобщенного типа T.
 * Этот контейнер поддерживает операции добавления, удаления и извлечения элементов.
 *
 * @param <T> Тип элементов, которые будут храниться в контейнере.
 */
public class Container<T> {
    private Node<T> head;
    private int size;

    /**
     * Создает новый экземпляр класса Container.
     * Контейнер инициализируется пустым (без элементов).
     */
    public Container() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Добавляет новый элемент в конец контейнера.
     *
     * @param data Данные элемента, который нужно добавить.
     */
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    /**
     * Удаляет элемент с указанным индексом из контейнера.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона");
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    /**
     * Получает элемент с указанным индексом из контейнера.
     *
     * @param index Индекс элемента, который нужно получить.
     * @return Элемент с указанным индексом.
     * @throws IndexOutOfBoundsException если индекс находится вне допустимого диапазона.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне допустимого диапазона");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Возвращает количество элементов в контейнере.
     *
     * @return Количество элементов в контейнере.
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли контейнер.
     *
     * @return true - контейнер пуст, иначе - false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
