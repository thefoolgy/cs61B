public class LinkedListDeque<T> {
    private StuffNode sentinel;
    private int size;

    private class StuffNode {
        private StuffNode prev;
        private T item;
        private StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public void addFirst(T x) {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    public void addLast(T x) {
        sentinel.prev = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        StuffNode ptr = sentinel.next;
        while (ptr.next.item != null) {
            System.out.print(ptr.item);
            System.out.print(" ");
        }
    }
    public T removeFirst() {
        if (size == 1 || size == 0){
            return null;
        }
        size--;
        return sentinel.next.item;
    }
    public T removeLast() {
        if (size == 1 || size == 0){
            return null;
        }
        size--;
        return sentinel.prev.item;
    }
    public T get(int index) {
        if (index == 0){
            return sentinel.next.item;
        }
        StuffNode ptr = sentinel.next;
        int count = 0;
        while (count <= index) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    private T getHelper(int index, StuffNode sentinel) {
        if (index  == 0) {
            return sentinel.next.item;
        }
        return getHelper(index - 1, sentinel.next);
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getHelper(index, sentinel);
    }
}
