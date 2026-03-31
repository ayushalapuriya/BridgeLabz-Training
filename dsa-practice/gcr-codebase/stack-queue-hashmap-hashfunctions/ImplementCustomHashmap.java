import java.util.LinkedList;

public class ImplementCustomHashmap {
    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class MyHashMap {
        private final int SIZE = 1000;
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public MyHashMap() {
            buckets = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int getBucketIndex(int key) {
            return key % SIZE;
        }

        public void put(int key, int value) {
            int index = getBucketIndex(key);
            LinkedList<Node> bucket = buckets[index];

            for (Node node : bucket) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }

            bucket.add(new Node(key, value));
        }

        public int get(int key) {
            int index = getBucketIndex(key);
            LinkedList<Node> bucket = buckets[index];

            for (Node node : bucket) {
                if (node.key == key) {
                    return node.value;
                }
            }

            return -1;
        }
        public void remove(int key) {
            int index = getBucketIndex(key);
            LinkedList<Node> bucket = buckets[index];

            bucket.removeIf(node -> node.key == key);
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        map.put(1, 10);
        map.put(2, 20);
        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));

        map.put(1, 15);
        System.out.println("Updated value for key 1: " + map.get(1));

        map.remove(2);
        System.out.println("Value for key 2 after removal: " + map.get(2));
    }
}
