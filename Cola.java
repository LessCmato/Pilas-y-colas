public class Cola {
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
    private Nodo frente;    // Referencia al primer elemento de la cola (el que se desencola)
    private Nodo fin;       // Referencia al último elemento de la cola (donde se encola)

    /**
     * Constructor de la cola.
     * Inicializa la cola vacía (frente y fin apuntan a null).
     */
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si no hay elementos, false en caso contrario
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Agrega un nuevo elemento al final de la cola (encolar).
     * @param dato valor entero que se desea agregar
     */
    public void encolar(int dato) {
        Nodo nuevo = new Nodo(dato);        // Se crea el nuevo nodo

        if (estaVacia()) {
            // Si la cola estaba vacía, el nuevo nodo es tanto el frente como el fin
            frente = nuevo;
            fin = nuevo;
            return;
        }

        // Si ya hay elementos, se enlaza el nuevo nodo al final y se actualiza fin
        fin.siguiente = nuevo;
        fin = nuevo;
    }

    /**
     * Elimina y devuelve el elemento que está al frente de la cola (desencolar).
     * @return el valor del elemento eliminado
     * @throws IllegalStateException si la cola está vacía
     */
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }

        int valor = frente.dato;            // Se guarda el valor a devolver
        frente = frente.siguiente;          // El frente ahora apunta al siguiente nodo

        // Si después de desencolar la cola queda vacía, también se actualiza fin
        if (frente == null) {
            fin = null;
        }

        return valor;
    }

    /**
     * Devuelve el valor del elemento que está al frente de la cola sin eliminarlo.
     * @return el valor del elemento al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public int verFrente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return frente.dato;
    }
    /**
     * Calcula y devuelve la cantidad de elementos que hay actualmente en la cola.
     * @return número de elementos en la cola
     */
    public int tamaño() {
        int contador = 0;
        Nodo actual = frente;

        // Se recorre toda la lista contando los nodos
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }

        return contador;
    }
    /**
     * Imprime en consola todos los elementos de la cola en orden (del frente al fin).
     * Si la cola está vacía, muestra un mensaje indicándolo.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La cola está vacía.");
            return;
        }
        Nodo actual = frente;
        // Se recorre la lista imprimiendo cada valor
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" → ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}