public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    private T getLast() {
        return items[size - 1];
    }
    private T getFirst() {
        return items[nextFirst + 1];
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        else if (nextLast == items.length - 1) {
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast += 1;
        size += 1;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        else if (nextFirst == 0) {
            nextFirst = items.length;
        }
        items[nextFirst] = item;
        nextFirst -= 1;
        size += 1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public void printDeque() {
        for (int i = 0; i < items.length; i++) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = getFirst();
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        return x;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = getLast();
        items[nextLast - 1] = null;
        nextLast -= 1;
        size -= 1;
        return x;
    }
    public T get(int index) {
        if (items[index] != null) {
            return items[index];
        }
        return null;
    }
    public int size() {
        return size;
    }
}