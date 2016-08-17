package hashtable;

public class HashNode<K, V> {

	private K key = null;
	private V value = null;
	private HashNode<K, V> nextNode;

	public HashNode(K key, V value, HashNode<K, V> nextNode) {
		super();
		this.key = key;
		this.value = value;
		this.nextNode = nextNode;
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

	public HashNode<K, V> getNextNode() {
		return nextNode;
	}

	public void setNextNode(HashNode<K, V> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "HashNode (key=" + key + ", value=" + value + ", nextNode="
				+ nextNode + ")";
	}

}
