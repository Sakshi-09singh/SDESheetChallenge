package Day26;

import java.util.HashMap;

public class LRU {
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public void LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            remove(map.get(key));
        }

        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);

            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        insert(newNode);

        map.put(key, newNode);
    }

    // Insert at front
    private void insert(Node node) {

        Node nextNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = nextNode;
        nextNode.prev = node;
    }

    // Remove node
    private void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
