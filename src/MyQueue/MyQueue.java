package MyQueue;

public class MyQueue<T> {
    private Node<T> head;
    private int size;

    public void add(T el) {
        Node<T> newnode = new Node<>(el);
        Node<T> current = head;
        if (head == null) {
            head = newnode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newnode;
        }
        size++;
    }

    public T peek() {
        if (head == null) {
            throw new NullPointerException();
        }
        return head.el;
    }

    public T poll() {
        if (head != null) {
            Node<T> result = head;
            head = head.next;
            size--;
            return result.el;
        } else throw new NullPointerException();

    }

    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = null;
            head = null;
            current = next;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Node current = head;
        while (current != null) {
            stringBuilder.append(current.el);
            current = current.next;
            if (current != null) {
                stringBuilder.append(", ");
            }
        }


        stringBuilder.append("}");
        return stringBuilder.toString();
    }


    private static class Node<T> {
        private Node<T> next;
        private T el;

        public Node(T el) {
            this.el = el;
        }
    }


}