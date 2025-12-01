public class CustomStack {

    private StackNode _head;

    public CustomStack() {
        _head = null;
    }

    public void push(String word) {
        var node = new StackNode(word);

        // Actualizar
        // insertar en el inicio de la lista
        node.setNext(_head);
        _head = node;
    }

    public String pop() {
        if (_head == null) {
            return null;
        }
        String word = _head.getWord();
        _head = _head.getNext();
        return word;
    }

    public int size() {
        var length = 0;

        // Actualizar
        // recorrer y contar elementos de la pila
        StackNode current = _head;
        while (current != null) {
            length++;
            current = current.getNext();
        }

        return length;
    }

    public String getWords() {
        var builder = new StringBuilder("(" + size() + ") [");
        for (var word = pop(); word != null; word = pop()) {
            builder.append(" " + word);
        }
        builder.append(" ]");
        return builder.toString();
    }
}

//No recurrï a ayuda externa para completar esta clase