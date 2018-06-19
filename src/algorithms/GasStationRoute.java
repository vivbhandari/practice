package algorithms;

public class GasStationRoute {

	public static int findGasStation(int[] gas, int cost[]) {
		int currentGas = 0;
		int totalStations = gas.length;
		int startIndex = 0;

		for (int i = 0; i < totalStations * 2; i++) {
			int gIndx = i % totalStations;
			if (i != 0) {
				int cIndx = gIndx == 0 ? totalStations - 1 : gIndx - 1;
				currentGas -= cost[cIndx];
				if (currentGas >= 0) {
					if (startIndex == gIndx)
						return gIndx;
				} else {
					currentGas = 0;
					startIndex = gIndx;
				}
			}
			currentGas += gas[gIndx];
		}
		return -1;
	}

	public static void main(String args[]) {
		System.out.println(findGasStation(
				new int[] { 5, 4, 6, 7 },
				new int[] { 4, 2, 3, 2 }));

		System.out.println(findGasStation(
				new int[] { 5, 4, 6, 7 },
				new int[] { 4, 6, 4, 2 }));
	}
}
