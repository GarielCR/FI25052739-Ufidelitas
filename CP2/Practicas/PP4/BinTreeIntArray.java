import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    public void insert(int value) {

        int index = 0;

        while (index < _tree.length) {
            if (_tree[index] == null) {
                _tree[index] = value;
                break;
            } else if (value < _tree[index]) {
                index = 2 * index + 1; // left
            } else if (value > _tree[index]) {
                index = 2 * index + 2; // right
            } else {
                //Si es el mismo valor no se inserta nada
                break;
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");
        var stack = new Stack<Integer>();
        var index = 0;
        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }
            index = stack.pop();
            System.out.print(_tree[index] + " ");
            index = 2 * index + 2;
        }
        System.out.println();
    }


    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        
        var stack = new Stack<Integer>();

        if (_tree.length > 0 && _tree[0] != null) {
            stack.push(0); // root
        }

        while (!stack.isEmpty()) {
            var index = stack.pop();
            System.out.print(_tree[index] + " ");

            int right = 2 * index + 2;
            int left = 2 * index + 1;

            // Primero se apila el hijo derecho para que el izquierdo se procese antes
            
            if (right < _tree.length && _tree[right] != null) {
                stack.push(right);
            }
            if (left < _tree.length && _tree[left] != null) {
                stack.push(left);
            }
        }

        System.out.println();
    }

    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        // 2 stacks ya que en una se recorre el arbol de manera (root-right-left) y en la otra se guardan los valores invertidos para cumplir con el ´post-order´
        var stack1 = new Stack<Integer>();
        var stack2 = new Stack<Integer>();

        if (_tree.length > 0 && _tree[0] != null) {
            stack1.push(0); // root
        }

        while (!stack1.isEmpty()) {
            var index = stack1.pop();
            stack2.push(index);

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < _tree.length && _tree[left] != null) {
                stack1.push(left);
            }
            if (right < _tree.length && _tree[right] != null) {
                stack1.push(right);
            }
        }
// Ahora se imprimen los valores en orden post-order
        while (!stack2.isEmpty()) {
            var index = stack2.pop();
            System.out.print(_tree[index] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);
        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal(); // 1 2 3 4 5 6 7
        tree.preOrderTraversal(); // 4 2 1 3 6 5 7
        tree.postOrderTraversal(); // 1 3 2 5 7 6 4
    }
}