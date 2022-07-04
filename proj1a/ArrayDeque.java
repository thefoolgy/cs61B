public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

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
    public void addLast(T item) {
        if (size == 0){
            items[nextLast] = item;
            nextLast += 1;
            size += 1;
        }
        else if (nextLast == items.length && size != items.length) {
            items[nextLast - items.length] = item;
            nextLast = 1;
            size += 1;
        }
        else if (size == items.length){
            resize(size * 2);
            items[nextLast] = item;
            size += 1;
        }

    }
    public void addFirst(T item) {
        if (size == 0) {
            items[nextFirst] = item;
            nextFirst -= 1;
            size += 1;
        }
        else if (nextFirst == 0 && size != items.length) {
            items[items.length] = item;
            nextFirst = items.length - 1;
            size += 1;
        }
        else if (size == items.length) {
            resize(size * 2);
            items[items.length] = item;
            nextFirst = items.length - 1;
            size += 1;
        }
    }
    public boolean isEmpty() {
        return size == 0;
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
        T x = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        return x;
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        size -= 1;
        return x;
    }
    public T get(int i) {
        return items[i];
    }
    public int size() {
        return size;
    }
}