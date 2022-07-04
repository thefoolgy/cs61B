public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4
        nextLast = 5;
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int start = addOne(nextFirst);
        System.arraycopy(items, start, a, 0, items.length - start);
        System.arraycopy(items, minusOne(nextLast), a, items.length - start, start - minusOne(nextLast));
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }
    private T getLast() {
        return items[minusOne(getLast)];
    }
    private T getFirst() {
        return items[addOne((nextFirst))];
    }
    private int addOne(int a) {
        return (a + 1) % items.length;
    }
    private int minusOne(int a) {
        return (a - 1 + items.length) % items.length;
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size += 1;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void printDeque() {
        int i = addOne(nextFirst);
        for (int j = 0; j < size; j++) {
            System.out.print(items[i] + " ");
            i = addOne(nextFirst);
        }
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = getFirst();
        items[addOne(nextFirst)] = null;
        nextFirst  = addOne(nextFirst);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length/2);
        }
        return x;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = getLast();
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length/2);
        }
        return x;
    }
    public T get(int index) {
        if (idnex > size) {
            return null;
        }
        int start = addOne(nextFirst);
        return items[(start + index) % items.length];
    }
    public int size() {
        return size;
    }
}