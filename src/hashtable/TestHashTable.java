package hashtable;

public class TestHashTable {

	public static void main(String args[]) {
		test2();
	}

	public static void test2() {
		Hashtable<Integer, Integer> hashtable = new Hashtable<Integer, Integer>(
				5);
		System.out.println(hashtable);
		for (int i = 0; i < 8; i++) {
			hashtable.put(i, i * i);
			System.out.println(hashtable);
		}
		hashtable.put(0, -1);
		System.out.println(hashtable);
		hashtable.put(0, 0);
		for (int i = 0; i < 8; i++) {
			System.out.println(hashtable.get(i));
		}
		System.out.println(hashtable);
		hashtable.resize(6);
		System.out.println(hashtable);
		hashtable.resize(4);
		System.out.println(hashtable);
		System.out.println(hashtable.remove(7));
		System.out.println(hashtable.remove(4));
		System.out.println(hashtable.remove(4));
		System.out.println(hashtable);
	}

	public static void test1() {
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		System.out.println(hashtable);
		hashtable.put("one", 1);
		System.out.println(hashtable);
		hashtable.put("two", 2);
		System.out.println(hashtable);
		hashtable.put("three", 3);
		System.out.println(hashtable);
		hashtable.put("one", 11);
		System.out.println(hashtable);
		hashtable.put("one", 1);
		System.out.println(hashtable);

		System.out.println(hashtable.get("one"));
		System.out.println(hashtable.get("two"));
		System.out.println(hashtable.get("three"));
		System.out.println(hashtable);
	}

}
