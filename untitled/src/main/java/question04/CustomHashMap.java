package question04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private List<Bucket<K, V>> buckets;

    public CustomHashMap() {
        buckets = new ArrayList<>(INITIAL_CAPACITY);
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets.add(new Bucket<>());
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Bucket<K, V> bucket = buckets.get(index);
        bucket.put(key, value);
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        Bucket<K, V> bucket = buckets.get(index);
        return bucket.containsKey(key);
    }

    public boolean isEmpty() {
        for (Bucket<K, V> bucket : buckets) {
            if (!bucket.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Bucket<K, V> bucket : buckets) {
            values.addAll(bucket.values());
        }
        return values;
    }

    public void replace(K key, V newValue) {
        int index = getIndex(key);
        Bucket<K, V> bucket = buckets.get(index);
        if (bucket.containsKey(key)) {
            bucket.put(key, newValue);
        }
    }

    private static class Bucket<K, V> {
        private List<Entry<K, V>> entries;

        public Bucket() {
            entries = new LinkedList<>();
        }

        public void put(K key, V value) {
            for (Entry<K, V> entry : entries) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }
            }
            entries.add(new Entry<>(key, value));
        }

        public boolean containsKey(K key) {
            for (Entry<K, V> entry : entries) {
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isEmpty() {
            return entries.isEmpty();
        }

        public List<V> values() {
            List<V> values = new ArrayList<>();
            for (Entry<K, V> entry : entries) {
                values.add(entry.getValue());
            }
            return values;
        }
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
