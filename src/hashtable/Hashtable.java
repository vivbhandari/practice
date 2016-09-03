package hashtable;

import java.util.Arrays;

@SuppressWarnings("unchecked")
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

	public void resize(int newSize) {
		Size = newSize;
		HashNode<K, V>[] origTable = table;
		table = new HashNode[newSize];

		for (HashNode<K, V> hashNode : origTable) {
			while (hashNode != null) {
				HashNode<K, V> nextNode = hashNode.getNextNode();
				hashNode.setNextNode(null);
				put(hashNode);
				hashNode = nextNode;
			}
		}
	}

	public void put(K key, V value) {
		put(new HashNode<K, V>(key, value, null));
	}

	public void put(HashNode<K, V> newNode) {
		K key = newNode.getKey();
		int hashCode = key.hashCode();
		int bucket = getBucket(hashCode);

		HashNode<K, V> hashNode = table[bucket];

		while (hashNode != null) {
			if (hashNode.getKey() == key) {
				System.out.println("key already exist: " + key);
				hashNode.setValue(newNode.getValue());
				return;
			} else {
				hashNode = hashNode.getNextNode();
			}
		}

		newNode.setNextNode(table[bucket]);
		table[bucket] = newNode;
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

	public V remove(K key) {
		int hashCode = key.hashCode();
		int bucket = getBucket(hashCode);
		V value = null;
		HashNode<K, V> hashNode = table[bucket];
		HashNode<K, V> prevNode = null;

		while (hashNode != null) {
			if (hashNode.getKey() == key) {
				value = hashNode.getValue();
				if (prevNode == null) {
					table[bucket] = hashNode.getNextNode();
				} else {
					prevNode.setNextNode(hashNode.getNextNode());
				}
				break;
			} else {
				prevNode = hashNode;
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
