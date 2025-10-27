import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;


//PD: Los metodos usados para dequeue y getFront (pollFirst y peekFirst) los encontre con ayuda de ChatGPT ya qwue no los conocia

public class TheQueue<Type> implements TheQueueInterface<Type> {

    private Deque<Type> _queue;

    public TheQueue() {
        _queue = new ArrayDeque<Type>();
    }

    public void enqueue(Type item) {
        _queue.add(item);
    }

    public Type dequeue() {
//Improvement: pollFirst() Devuelve y elimina el frente de la cola o null si esta vacia, sin condicionales

        return _queue.pollFirst(); 
    }

    public Type getFront() {
//Improvement: peekFirst() Devuelve el frente de la cola sin eliminarlo o null si está vacía, sin condicionales

        return _queue.peekFirst();
    }

    public boolean isEmpty() {
        return _queue.isEmpty();
    }

    public int getSize() {
        return _queue.size();
    }

    public String[] getCodons() {
// Update: se crea el arreglo de codones en el cual se hace uso del metodo dequeue para obtener los elementos de la cola en forma de Tripletas, sin exceder el limite de la cola
        var size = _queue.size();
        String[] codons = new String[size / 3];

        for (int i = 0; i < size/3; i++) {
            String a = String.valueOf(dequeue());
            String b = String.valueOf(dequeue());
            String c = String.valueOf(dequeue());
            codons[i] = a + b + c;
        }         
       return codons;

    }

    public String print() {
        return _queue.toString();
    }

    public static void main(String[] args) {
        var amount = Integer.parseInt(args[0]);
        String[] nucleotides = {
                "A", // [0]
                "C", // [1]
                "G", // [2]
                "T", // [3]
        };
        TheQueueInterface<String> queue = new TheQueue<String>();
        var random = new Random();
        for (; amount > 0; amount--) {
            var index = random.nextInt(4);
            var amino = nucleotides[index];
            queue.enqueue(amino);
        }
        System.out.println("Filled {full}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
        System.out.println("\ngetCodons() → " + Arrays.toString(queue.getCodons()));
        System.out.println("\nEnd {empty}");
        System.out.println(" ↳ print() → " + queue.print());
        System.out.println("   ↳ getFront() → " + queue.getFront());
        System.out.println("   ↳ getSize() → " + queue.getSize());
        System.out.println("   ↳ isEmpty() → " + queue.isEmpty());
    }
}