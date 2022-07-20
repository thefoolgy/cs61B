package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T>{
    public int capacity();
    public int fillCount();
    public void enqueue(T x);
    public T dequeue();
    public T peek();
    default boolean isEmpty() {
        if (capacity() == 0) {
            return true;
        }
        return false;
    }
    default boolean isFull() {
        if (fillCount() == capacity()) {
            return true;
        }
        return false;
    }
    public Iterator<T> iterator();
}
