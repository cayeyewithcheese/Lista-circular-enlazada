public class Main {

    public static void main(String[] args) {

        MiListaCircular lista = new MiListaCircular();

        System.out.println("===== LISTA CIRCULAR =====");


        System.out.println("¿Está vacía?: " + lista.isEmpty());


        lista.add(10);
        lista.add(20);
        lista.add(30);

        System.out.println("Lista: " + lista);
        System.out.println("Tamaño: " + lista.getSize());

        // head y tail
        System.out.println("Cabeza: " + lista.getHead());
        System.out.println("Cola: " + lista.getTail());


        lista.insertHead(5);

        System.out.println("Después de insertar cabeza: " + lista);


        lista.insertTail(40);

        System.out.println("Después de insertar cola: " + lista);


        Node nodo20 = lista.search(20);

        System.out.println("¿Está el 20?: " + lista.contains(20));
        System.out.println("¿Está el 100?: " + lista.contains(100));


        System.out.println("Dato del nodo 20: " + lista.get(nodo20));


        lista.insert(nodo20, 25);

        System.out.println("Después de insertar 25 después de 20: " + lista);


        lista.insert(25, 27);

        System.out.println("Después de insertar 27 después de 25: " + lista);


        lista.set(nodo20, 22);

        System.out.println("Después de modificar 20 a 22: " + lista);


        Node nodo25 = lista.search(25);
        lista.remove(nodo25);

        System.out.println("Después de eliminar 25: " + lista);

        Object[] arreglo = lista.toArray();

        System.out.print("Array: ");

        for (Object elemento : arreglo) {
            System.out.print(elemento + " ");
        }

        System.out.println();

        Node desde = lista.search(10);
        Node hasta = lista.search(40);

        MiListaCircular sublista = lista.subList(desde, hasta);

        System.out.println("Sublista: " + sublista);

        MiListaCircular ordenada = lista.sortList();

        System.out.println("Lista ordenada: " + ordenada);

        lista.clear();

        System.out.println("Después de clear: " + lista);
        System.out.println("¿Está vacía?: " + lista.isEmpty());
        System.out.println("Tamaño final: " + lista.getSize());
    }
}