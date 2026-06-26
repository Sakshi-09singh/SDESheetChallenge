package Day26;

import java.util.HashMap;

public class LRU1 {
    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head, tail;
        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {

            Node nextNode = head.next;

            head.next = node;
            node.prev = head;

            node.next = nextNode;
            nextNode.prev = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0) {
                return null;
            }

            Node lastNode = tail.prev;

            remove(lastNode);

            return lastNode;
        }
    }

    private int capacity;
    private int minFreq;

    private HashMap<Integer, Node> keyMap;
    private HashMap<Integer, DoublyLinkedList> freqMap;

    public void LFUCache(int capacity) {

        this.capacity = capacity;

        minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            updateFreq(node);

            return;
        }

        // Cache full
        if (keyMap.size() == capacity) {

            DoublyLinkedList minList = freqMap.get(minFreq);

            Node nodeToRemove = minList.removeLast();

            keyMap.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        minFreq = 1;

        DoublyLinkedList list =
            freqMap.getOrDefault(1, new DoublyLinkedList());

        list.addFirst(newNode);

        freqMap.put(1, list);

        keyMap.put(key, newNode);
    }

    private void updateFreq(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        // Update min frequency
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
            freqMap.getOrDefault(node.freq,
                                 new DoublyLinkedList());

        newList.addFirst(node);

        freqMap.put(node.freq, newList);
    }
}
