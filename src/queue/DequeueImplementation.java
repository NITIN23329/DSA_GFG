package queue;

class Node<T>{
    T data;
    Node<T> prev , next;
    public Node(T data){
        this.data = data;
    }
}
class Dequeue<T> implements DequeueFunctions<T> {
    Node<T> front,rear;

    @Override
    public T peekFront() {
        if(front==null)return null;
        return front.data;
    }

    @Override
    public T peekRear() {
        if(rear==null)return null;
        return rear.data;
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public void addRear(T data) {
        if(rear==null){
            front = new Node<T>(data);
            rear = front;
            return;
        }
        Node<T> temp = new Node<T>(data);
        rear.next = temp;
        temp.prev = rear;
        rear = rear.next;
    }

    @Override
    public void addFront(T data) {
        if(front==null){
            front = new Node<T>(data);
            rear = front;
            return;
        }
        Node<T> temp = new Node<T>(data);
        temp.next =front;
        front.prev = temp;
        front = front.prev;
    }

    @Override
    public T pollRear() {
     if(rear==null)return null;
     if(front==rear){
         T temp = rear.data;
         rear = null;
         front=null;
         return temp;
     }
     T temp = rear.data;
     rear = rear.prev;
     rear.next=null;
     return temp;
    }

    @Override
    public T pollFront() {
       if(front==null)return null;
        if(front==rear){
            T temp = front.data;
            rear = null;
            front=null;
            return temp;
        }
        T temp = front.data;
        front = front.next;
        front.prev=null;
        return temp;
    }
    @Override
    public void print(){
        Node<T> temp = front;
        do{
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while (temp!=null);
        System.out.println();
    }
}
public class DequeueImplementation{
    public static void main(String[] args) {
        Dequeue<Integer> dequeue = new Dequeue<>();
        dequeue.addFront(12);
        dequeue.addFront(24);
        System.out.println(dequeue.peekRear());
        System.out.println(dequeue.peekFront());
        dequeue.addRear(34);
        dequeue.print();
        System.out.println(dequeue.pollFront());
        System.out.println(dequeue.pollRear());
        dequeue.print();
        dequeue.addRear(10);
        dequeue.addRear(100);
        dequeue.addFront(5);
        System.out.println(dequeue.peekFront()+" "+dequeue.peekRear());
        System.out.println(dequeue.pollFront());
        System.out.println(dequeue.pollFront());
        System.out.println(dequeue.pollFront());
        System.out.println(dequeue.pollFront());
        System.out.println(dequeue.pollFront());
        System.out.println(dequeue.pollRear());
        System.out.println(dequeue.isEmpty());
        dequeue.addRear(12);
        System.out.println(dequeue.peekFront());


            
    }
}
