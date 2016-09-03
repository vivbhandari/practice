package lru;

public class LRUCache<K, V> {

	private LinkedHashMapWithCapacity<K, V> map;

	public LRUCache(int capacity) {
		map = new LinkedHashMapWithCapacity<K, V>(capacity);
	}

	public void set(K key, V value) {
		if (map.containsKey(key)) {
			map.remove(key);
		}
		map.put(key, value);
	}

	public V get(K key) {
		V value = map.remove(key);
		if (value != null) {
			this.set(key, value);
		}
		return value;
	}

	@Override
	public String toString() {
		return "LRUCache [map=" + map + "]";
	}
}
