public class MiListaCircular implements ListInterface{

    private Node head;
    private Node tail;
    private int size;

    public MiListaCircular() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public Object getHead() {
        if (head == null) {
            return null;
        }

        return head.dato;
    }

    @Override
    public Object getTail() {
        if (tail == null) {
            return null;
        }

        return tail.dato;
    }

    @Override
    public Object get(Node node) {
        if (node == null) {
            return null;
        }

        return node.dato;
    }

    @Override
    public Node search(Object object) {
        if (head == null) {
            return null;
        }

        Node actual = head;

        do {
            if (actual.dato.equals(object)) {
                return actual;
            }

            actual = actual.siguiente;

        } while (actual != head);

        return null;

    }

    @Override
    public boolean add(Object object) {
        Node nuevo = new Node(object);

        if (head == null) {

            head = nuevo;
            tail = nuevo;

            tail.siguiente = head;

        } else {

            nuevo.siguiente = head;
            tail.siguiente = nuevo;
            tail = nuevo;
        }

        size++;

        return true;
    }

    @Override
    public boolean insert(Node node, Object object) {
        if (node == null || head == null) {
            return false;
        }

        Node actual = head;

        do {

            if (actual == node) {

                Node nuevo = new Node(object);

                nuevo.siguiente = node.siguiente;
                node.siguiente = nuevo;

                if (node == tail) {
                    tail = nuevo;
                }

                tail.siguiente = head;

                size++;

                return true;
            }

            actual = actual.siguiente;

        } while (actual != head);

        return false;
    }

    @Override
    public boolean insert(Object objectRef, Object object) {
        Node nodo = search(objectRef);

        if (nodo == null) {
            return false;
        }

        return insert(nodo, object);
    }

    @Override
    public boolean insertHead(Object object) {
        Node nuevo = new Node(object);

        if (head == null) {

            head = nuevo;
            tail = nuevo;

            tail.siguiente = head;

        } else {

            nuevo.siguiente = head;
            head = nuevo;

            tail.siguiente = head;
        }

        size++;

        return true;
    }

    @Override
    public boolean insertTail(Object object) {
        return add(object);
    }

    @Override
    public boolean set(Node node, Object object) {
        if (node == null || head == null) {
            return false;
        }

        Node actual = head;

        do {

            if (actual == node) {
                node.dato = object;
                return true;
            }

            actual = actual.siguiente;

        } while (actual != head);

        return false;
    }

    @Override
    public boolean remove(Node node) {
        if (node == null || head == null) {
            return false;
        }

        if (head == tail) {

            if (node == head) {
                head = null;
                tail = null;
                size--;

                return true;
            }

            return false;
        }

        if (node == head) {

            head = head.siguiente;
            tail.siguiente = head;

            size--;

            return true;
        }

        Node anterior = head;
        Node actual = head.siguiente;

        while (actual != head) {

            if (actual == node) {

                anterior.siguiente = actual.siguiente;

                if (actual == tail) {
                    tail = anterior;
                    tail.siguiente = head;
                }

                size--;

                return true;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        if (head == null) {
            return array;
        }

        Node actual = head;
        int i = 0;

        do {

            array[i] = actual.dato;
            i++;

            actual = actual.siguiente;

        } while (actual != head);

        return array;
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }

    @Override
    public MiListaCircular subList(Node from, Node to) {
        return null;
    }

    @Override
    public MiListaCircular sortList() {
        return null;
    }
}
