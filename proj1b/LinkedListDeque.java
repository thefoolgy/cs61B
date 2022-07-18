public class LinkedListDeque<T> implements Deque<T>{
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
    @Override
    public void addFirst(T x) {
        sentinel.next = new StuffNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }
    @Override
    public void addLast(T x) {
        sentinel.prev = new StuffNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        StuffNode ptr = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
        System.out.print(ptr.item);
    }
    @Override
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T x = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return x;
    }
    @Override
    public T removeLast() {
        if (size == 0){
            return null;
        }
        T x = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return x;
    }
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        StuffNode ptr = sentinel.next;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    private T getHelper(int index, StuffNode x) {
        if (index  == 0) {
            return x.item;
        }
        return getHelper(index - 1, x.next);
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getHelper(index, sentinel.next);
    }
}
