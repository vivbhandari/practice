package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapWithCapacity<K, V> extends LinkedHashMap<K, V> {
	private static final long serialVersionUID = -5152280555285814526L;
	private int capacity;

	public LinkedHashMapWithCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return capacity < this.size();
	}
}
