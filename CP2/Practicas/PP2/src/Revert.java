import java.io.*;
import java.util.ArrayList;

public class Revert {

    static class MyStack<Type> {

// Aqui se crea la estructura de la pila y sus metodos para manipularla
        private ArrayList<Type> myList = new ArrayList<Type>();

        public void push(Type item) {
            myList.add(item);
        }

        public Type pop() {
            if (empty()) {
                return null;
            }
    // el -1 es para indicar el ultimo elemento de la lista
            return myList.remove(myList.size() - 1);
        }

        public boolean empty() {
            return myList.isEmpty();
        }

        public int size() {
            return myList.size();
        }

        public Type peek() {
            if (empty()) {
                return null;
            }
    
            return myList.get(myList.size() - 1);
        }
    }


    public static void main(String[] args) {

    // Nombres de los archivos de entrada y salida
        String inputFile = "input.txt";
        String outputFile = "output.txt";

    // Crear una instancia de la pila
        MyStack<Character> stack = new MyStack<>();

    // Leer el archivo de entrada y almacenar los caracteres en la pila
        try (
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
        ) {

            int caracter;
            
    // Leer cada caracter del archivo y empujarlo a la pila uno por uno 

            while (true) {
                caracter = br.read();
                stack.push((char) caracter);

    //Si se llega al final del archivo, salir del bucle (-1 en ASCII significa que se llego al final del archivo)
                if (caracter == -1) { 
                    break; 
                }
            }

    
    // Crear el archivo de salida
            try (
                FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw);
            ) {

    //verificar si la pila no esta vacia y sacar todos caracteres de la pila para escribirlos en el archivo de salida
                while (!stack.empty()) {
                    bw.write(stack.pop());
                }
                System.out.println("Archivo invertido creado correctamente: " + outputFile);
            }

    // Excepcion recomendada por ChatGPT en caso de algun error de entrada/salida
        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}