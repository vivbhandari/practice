package hashtable;

import java.util.Arrays;

public class Hashtable<K, V> {

	private int Size;
	HashNode<K, V>[] table;

	public Hashtable() {
		this(13);
	}

	public Hashtable(int size) {
		super();
		Size = size;
		table = new HashNode[Size];
	}

	private int getBucket(int hashCode) {
		return hashCode % Size;
	}

	public void put(K key, V value) {
		int hashCode = key.hashCode();
		int bucket = getBucket(hashCode);

		HashNode<K, V> hashNode = table[bucket];

		while (hashNode != null) {
			if (hashNode.getKey() == key) {
				System.out.println("key already exist: " + key);
				hashNode.setValue(value);
				return;
			} else {
				hashNode = hashNode.getNextNode();
			}
		}

		table[bucket] = new HashNode<K, V>(key, value, table[bucket]);
	}

	public V get(K key) {
		int hashCode = key.hashCode();
		int bucket = getBucket(hashCode);
		V value = null;
		HashNode<K, V> hashNode = table[bucket];

		while (hashNode != null) {
			if (hashNode.getKey() == key) {
				value = hashNode.getValue();
				break;
			} else {
				hashNode = hashNode.getNextNode();
			}
		}
		return value;
	}

	@Override
	public String toString() {
		return "Hashtable {table=" + Arrays.toString(table) + "}";
	}
}
