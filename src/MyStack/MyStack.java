package MyStack;

public class MyStack<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        private Node<T> next;
        private T el;

        public Node(T el) {
            this.el = el;
        }
    }

    public void push(T el) {
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
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.next != null) {
                current = current.next;
            }
        }
        return current.el;
    }

    public T pop() {
        if (head == null) {
            throw new NullPointerException();
        }

        Node<T> prev = null;
        Node<T> current = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        T el = current.el;
        if (prev != null) {
            prev.next = null;
        } else {
            head = null;
        }
        size--;

        return el;
    }

    public void clear() {
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = null;
            head = null;
            curr = next;
        }
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        Node<T> prev = null;
        Node<T> curr = head;
        if (index == 0) {
            head = head.next;
            return;
        }
        if (index > size) {
            throw new NullPointerException();
        }
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;


        }
        prev.next = curr.next;

        size--;
    }

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

}