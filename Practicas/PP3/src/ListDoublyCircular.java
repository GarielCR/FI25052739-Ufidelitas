import java.util.ArrayDeque;
import java.util.Random;

public class ListDoublyCircular<T> implements ListInterface<T> {

    private NodeDoubly<T> head = null; // First, Front, Initial node
    private NodeDoubly<T> tail = null; // Last node

    public ListDoublyCircular() {
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(T value) {

        NodeDoubly<T> newNode = new NodeDoubly<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }


    }

    @Override
    public void addLast(T value) {

        NodeDoubly<T> newNode = new NodeDoubly<>(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }

    }

    @Override
    public T removeFirst() {

        //Si esta vacia
        if (isEmpty()) {
            return null;
        }
        T value = head.data;

        // Si solo hay un elemento
        if (head == tail) {
            head = null;
            tail = null;

        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        return value;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
        return null;
        }
        T value = tail.data;

        // Si solo hay un elemento
        if (head == tail) {
            head = null;
            tail = null;
        }   else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }

        return value;
    }

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }
    
    @Override
    public Boolean isEmpty() {
        return head == null;
    }

    @Override
    public Integer getSize() {
        var size = 0;
        if (!isEmpty()) {
            var current = head;
            do {
                size++;
                current = current.next;
            } while (current != tail.next);
        }
        return size;
    }

    @Override
    public void printList() {
        if (!isEmpty()) {
            var curr = head;
            do {
                System.out.println("\t" + curr.prev.data + " ⇄ | " + curr.data + " | ⇄ " + curr.next.data);
                curr = curr.next;
            } while (curr != tail.next);
        }
    }

    @Override
    public void printListInReverse() {
        if (!isEmpty()) {
            var curr = tail;
            System.out.print("| ");
            do {
                System.out.print(curr.data + " | ");
                curr = curr.prev;
            } while (curr != head.prev);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        var n = Integer.parseInt(args[0]);
        ListInterface<Integer> list = new ListDoublyCircular<Integer>();
        var arrayDeque = new ArrayDeque<Integer>();
        var random = new Random();
        for (var counter = n * 2; counter > 0; counter--) {
            var value = random.nextInt(0, 10);
            list.addFirst(value);
            arrayDeque.addFirst(value);
            value = random.nextInt(0, 10);
            list.addLast(value);
            arrayDeque.addLast(value);
        }
        System.out.println();
        System.out.println("List {added: n * 4}: " + arrayDeque);
        System.out.println(" ↳ Size: " + list.getSize());
        System.out.println(" ↳ Empty: " + list.isEmpty());
        System.out.println(" ↳ First: " + list.getFirst());
        System.out.println(" ↳ Last: " + list.getLast());
        System.out.print(" ↳ Reverse: ");
        list.printListInReverse();
        System.out.println(" ↳ Print: ");
        list.printList();
        for (var counter = n; counter > 0; counter--) {
            list.removeFirst();
            arrayDeque.removeFirst();
            list.removeLast();
            arrayDeque.removeLast();
        }
        System.out.println();
        System.out.println("List {removed: n * 2}: " + arrayDeque);
        System.out.println(" ↳ Size: " + list.getSize());
        System.out.println(" ↳ Empty: " + list.isEmpty());
        System.out.println(" ↳ First: " + list.getFirst());
        System.out.println(" ↳ Last: " + list.getLast());
        System.out.print(" ↳ Reverse: ");
        list.printListInReverse();
        System.out.println(" ↳ Print: ");
        list.printList();
        for (var counter = arrayDeque.size(); counter > 0; counter--) {
            list.removeFirst();
            list.removeLast();
        }
        arrayDeque.clear();
        System.out.println();
        System.out.println("List {empty}: " + arrayDeque);
        System.out.println(" ↳ Size: " + list.getSize());
        System.out.println(" ↳ Empty: " + list.isEmpty());
        System.out.println(" ↳ First: " + list.getFirst());
        System.out.println(" ↳ Last: " + list.getLast());
        System.out.print(" ↳ Reverse: ");
        list.printListInReverse();
        System.out.println(" ↳ Print: ");
        list.printList();
    }
}
