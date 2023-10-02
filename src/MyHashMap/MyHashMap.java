package MyHashMap;


import java.util.*;

public class MyHashMap<T, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<T, V>[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    public void put(T key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Node<T, V> prev = null;
        Node<T, V> curr = table[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        Node newNode = new Node(key, value, hash);
        if (prev == null) {
            table[index] = newNode;
        } else {
            prev.next = newNode;
        }
        size++;

        if (size > table.length * LOAD_FACTOR) {
            resize();
        }
    }

    public V get(T key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Node<T, V> curr = table[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }

        return null;
    }

    public V remove(T key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Node<T, V> prev = null;
        Node<T, V> curr = table[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }

        return null;
    }
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Node[] oldTable = table;
        table = new Node[table.length * 2];
        size = 0;

        for (Node node : oldTable) {
            while (node != null) {
                put((T) node.key, (V) node.value);
                node = node.next;
            }
        }
    }

    private int hash(T key) {
        return key == null ? 0 : key.hashCode();
    }

    private int indexFor(int hash, int length) {
        return (length - 1) & hash;
    }

    private static class Node<T, V> {
        private final T key;
        private V value;
        private final int hash;
        private Node<T, V> next;

        public Node(T key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (Node node : table) {
            while (node != null) {
                sb.append(node.key).append("=").append(node.value).append(", ");
                node = node.next;
            }
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("}");
        return sb.toString();
    }
}