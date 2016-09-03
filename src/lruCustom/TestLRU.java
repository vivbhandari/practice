package lruCustom;

public class TestLRU {
	public static void main(String args[]) {
		int capacity = 4;
		LRUCache<Integer, Integer> lruCache = new LRUCache<Integer, Integer>(
				capacity);
		for (int i = 0; i < capacity; i++) {
			lruCache.set(i, i * i);
		}
		System.out.println(lruCache);
		System.out.println(lruCache.get(0));
		System.out.println(lruCache);
		lruCache.set(4, 16);
		System.out.println(lruCache);
		System.out.println(lruCache.get(1));
		lruCache.set(5, 25);
		System.out.println(lruCache);
		lruCache.set(4, 17);
		System.out.println(lruCache);
	}

}
