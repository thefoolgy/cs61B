public class ArrayDeque<Item> {
    Item[] items;
    int size;
    int nextFirst;
    int nextLast;

    public ArrayDeque() {
        items = (Item[]) new Object(8);
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object(capacity);
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addLast(Item x) {
        if (size = 0){
            items[nextLast] = x;
            nextLast += 1;
            size += 1;
        }
        else if (nextLast == items.length && size != items.length) {
            items[nextLast - items.length] = x;
            nextLast = 1;
            size += 1;
        }
        else if (size == items.length){
            resize(size * 2);
            items[nextLast] = x;
            size += 1;
        }

    }
    public void addFirst(Item x) {
        if (size = 0) {
            items[nextFirst] = x;
            nextFirst -= 1;
            size += 1;
        }
        else if (nextFirst == 0 && size != items.length) {
            items[items.length] = x;
            nextFirst = items.length - 1;
            size += 1;
        }
        else if (size == items.length) {
            resize(size * 2);
            items[items.length] = x;
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
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        item x = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        return x;
    }
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        item x = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        size -= 1;
        return x;
    }
    public Item get(int i) {
        return items[i];
    }
    public int size() {
        return size;
    }
}