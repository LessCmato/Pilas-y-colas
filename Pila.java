public class Pila {
    /**
     * Clase interna que representa un nodo de la lista enlazada.
     * Cada nodo contiene un dato entero y una referencia al siguiente nodo.
     */
    private static class Nodo {
        int dato;           // Valor almacenado en el nodo
        Nodo siguiente;     // Referencia al siguiente nodo (null si es el último)
        /**
         * Constructor del nodo.
         * @param dato valor entero que se almacenará en este nodo
         */
        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    private Nodo tope;      // Referencia al elemento que está en la cima de la pila
    /**
     * Constructor de la pila.
     * Inicializa la pila vacía (tope apunta a null).
     */
    public Pila() {
        this.tope = null;
    }
    /**
     * Verifica si la pila está vacía.
     * @return true si no hay elementos, false en caso contrario
     */
    public boolean estaVacia() {
        return tope == null;
    }
    /**
     * Agrega un nuevo elemento en la cima de la pila (push).
     * @param dato valor entero que se desea agregar
     */
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);        // Se crea el nuevo nodo
        nuevo.siguiente = tope;             // El nuevo nodo apunta al actual tope
        tope = nuevo;                       // El nuevo nodo se convierte en el tope
    }
    /**
     * Elimina y devuelve el elemento que está en la cima de la pila (pop).
     * @return el valor del elemento eliminado
     * @throws IllegalStateException si la pila está vacía
     */
    public int pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }

        int valor = tope.dato;              // Se guarda el valor a devolver
        tope = tope.siguiente;              // El tope ahora apunta al siguiente nodo
        return valor;
    }
    /**
     * Devuelve el valor del elemento que está en la cima de la pila sin eliminarlo (peek).
     * @return el valor del elemento en la cima
     * @throws IllegalStateException si la pila está vacía
     */
    public int peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return tope.dato;
    }
    /**
     * Calcula y devuelve la cantidad de elementos que hay actualmente en la pila.
     * @return número de elementos en la pila
     */
    public int tamaño() {
        int contador = 0;
        Nodo actual = tope;

        // Se recorre toda la lista contando los nodos
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }

        return contador;
    }
    /**
     * Imprime en consola todos los elementos de la pila desde la cima hacia abajo.
     * Si la pila está vacía, muestra un mensaje indicándolo.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
            return;
        }
        Nodo actual = tope;
        // Se recorre la lista imprimiendo cada valor
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" ↓ ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}