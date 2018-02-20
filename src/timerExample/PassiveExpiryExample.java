package timerExample;

import org.apache.commons.collections4.map.PassiveExpiringMap;

class expiringPolicySL implements PassiveExpiringMap.ExpirationPolicy<String, Long> {
	private static final long serialVersionUID = 1L;

	@Override
	public long expirationTime(String arg0, Long arg1) {
		System.out.println("called SL for " + arg0);
		return arg1;
	}
}

class expiringPolicyLL implements PassiveExpiringMap.ExpirationPolicy<Long, Long> {
	private static final long serialVersionUID = 1L;

	@Override
	public long expirationTime(Long arg0, Long arg1) {
		System.out.println("called LL for " + arg0);
		return arg1;
	}
}

class expiringPolicySP
		implements PassiveExpiringMap.ExpirationPolicy<String, PassiveExpiringMap<Long, Long>> {
	private static final long serialVersionUID = 1L;

	@Override
	public long expirationTime(String arg0, PassiveExpiringMap<Long, Long> arg1) {
		System.out.println("called SP for " + arg0);
		return arg1.isEmpty() ? System.currentTimeMillis() : -1;
	}
}

public class PassiveExpiryExample {

	public static void main(String args[]) throws InterruptedException {
		// PassiveExpiringMap<String, Long> testMap = new
		// PassiveExpiringMap<String, Long>(
		// new expiringPolicySL());
		// for (int i = 0; i < 5; i++) {
		// testMap.put("" + i, System.currentTimeMillis() + (i + 2) * 1000);
		// System.out.println(testMap);
		// }
		//
		// while (!testMap.isEmpty()) {
		// for (int i = 0; i < 5; i++) {
		// System.out.println(i + "=" + testMap.get("" + i));
		// }
		// Thread.sleep(1000);
		// }
		// System.out.println(testMap);

		PassiveExpiringMap<String, PassiveExpiringMap<Long, Long>> twoLevelMap = new PassiveExpiringMap<String, PassiveExpiringMap<Long, Long>>(
				new expiringPolicySP());

		for (int i = 0; i < 5; i++) {
			String key1 = "" + (i % 2);
			PassiveExpiringMap<Long, Long> innerMap = twoLevelMap.get(key1);
			if (innerMap == null) {
				innerMap = new PassiveExpiringMap<Long, Long>(new expiringPolicyLL());
				innerMap.put((long) i, System.currentTimeMillis() + (i + 2) * 1000);
				twoLevelMap.put(key1, innerMap);
			} else {
				innerMap.put((long) i, System.currentTimeMillis() + (i + 2) * 1000);
			}
			System.out.println(twoLevelMap);
		}

		while (!twoLevelMap.isEmpty()) {
			for (int i = 0; i < 5; i++) {
				PassiveExpiringMap<Long, Long> innerMap = twoLevelMap.get("" + (i % 2));
				System.out.println(innerMap);
				System.out.println(innerMap.get((long)i));
			}
			Thread.sleep(1000);
		}

		System.out.println(twoLevelMap);
	}
}
