package lruCustom;

public class LRUNode<K, V> {

	K key;
	V value;
	LRUNode<K, V> previous;
	LRUNode<K, V> next;

	public LRUNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "LRUNode [key=" + key + ", value=" + value + "]";
	}

}
