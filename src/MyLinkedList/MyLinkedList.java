package MyLinkedList;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public void add(T el) {
        Node<T> newNode = new Node<>(el);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.previos = last;
            last = newNode;
        }
        size++;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = first;
        for (int i = 0; i < index; i++) {
            if (curr.next != null) {
                curr = curr.next;
            }
        }
        return  curr.el;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.previos == null) {
            first = current.next;
        } else {
            current.previos.next = current.next;
        }
        if (current.next == null) {
            last = current.previos;
        } else {
            current.next.previos = current.previos;
        }
        size--;
    }
    public void clear(){
        Node current = first;
        while (current != null) {
            Node next = current.next;
            current.previos = null;
            current.next = null;
            current.previos = null;
            current = next;
        }

        first = null;
        last = null;
        size = 0;
    }
    public int size(){
        return size;
    }

    private static class Node<T> {
        private Node<T> next;
        private Node<T> previos;
        private T el;

        public Node(T el) {
            this.el = el;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curr = first;
        while (curr != null) {
            sb.append(curr.el);
            curr = curr.next;
            if (curr != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }



}