package lruCustom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCache<K, V> {

	private int capacity;
	private LRUNode<K, V> head;
	private LRUNode<K, V> end;
	private HashMap<K, LRUNode<K, V>> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<K, LRUNode<K, V>>();
	}

	private void setHead(LRUNode<K, V> lruNode) {
		if (head != null) {
			lruNode.next = head;
			head.previous = lruNode;
		}
		head = lruNode;

		if (end == null)
			end = head;
	}

	private void remove(LRUNode<K, V> lruNode) {
		if (lruNode.previous != null)
			lruNode.previous.next = lruNode.next;
		else
			head = lruNode.next;

		if (lruNode.next != null)
			lruNode.next.previous = lruNode.previous;
		else
			end = lruNode.previous;
		
		lruNode.next = null;
		lruNode.previous = null;
	}

	public void set(K key, V value) {
		LRUNode<K, V> lruNode;
		if (map.containsKey(key)) {
			lruNode = map.get(key);
			lruNode.value = value;
			remove(lruNode);
		} else {
			if (map.size() == capacity) {
				map.remove(end.key);
				remove(end);
			}
			lruNode = new LRUNode<K, V>(key, value);
		}
		setHead(lruNode);
		map.put(key, lruNode);
	}

	public V get(K key) {
		V value = null;

		LRUNode<K, V> lruNode = map.get(key);
		if (lruNode != null) {
			value = lruNode.value;
			if (lruNode != head) {
				remove(lruNode);
				setHead(lruNode);
			}
		}

		return value;
	}

	@Override
	public String toString() {
		List<LRUNode<K, V>> list = new ArrayList<LRUNode<K, V>>();
		LRUNode<K, V> lruNode = head;
		while (lruNode != null) {
			list.add(lruNode);
			lruNode = lruNode.next;
		}
		return "LRUCache [list=" + list + ", map=" + map.entrySet() + "]";
	}

}
