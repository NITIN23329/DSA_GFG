package queue;

public interface DequeueFunctions<T> {
     T peekFront();
    T peekRear();
    boolean isEmpty();
    void addRear(T data);
    void addFront(T data);
    T pollRear();
    T pollFront();
    void print();
}
