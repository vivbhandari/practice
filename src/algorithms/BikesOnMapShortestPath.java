package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BikesOnMapShortestPath {

	public int iterations = 0;
	List<Location> people;
	List<Location> bikes;

	public BikesOnMapShortestPath(List<Location> people, List<Location> bikes) {
		super();
		this.people = people;
		this.bikes = bikes;
	}

	private double getDistance(Location person, Location bike) {
		return Math.sqrt(Math.pow((person.x - bike.x), 2)
				+ Math.pow((person.y - bike.y), 2));
	}

	public List<Integer> calculate() {
		double[][] costMatrix = new double[people.size()][bikes.size()];

		for (int i = 0; i < people.size(); i++) {
			for (int j = 0; j < bikes.size(); j++) {
//				iterations++;
				costMatrix[i][j] = getDistance(people.get(i), bikes.get(j));
			}
		}

		for (int i = 0; i < people.size(); i++)
			System.out.println(Arrays.toString(costMatrix[i]));

		List<Integer> result = new ArrayList<Integer>();
		getMinCost(costMatrix, 0, new ArrayList<Integer>(), 0, Double.MAX_VALUE,
				result);
		System.out.println("iterations=" + iterations);
		return result;
	}

	private double getMinCost(double[][] costMatrix, int person,
			List<Integer> allocations, double totalCostSoFar, double minCost,
			List<Integer> result) {
		if (allocations.size() == bikes.size()) {
			if (totalCostSoFar < minCost) {
				minCost = totalCostSoFar;
				result.clear();
				result.addAll(allocations);
			}
		} else {
			for (int j = 0; j < bikes.size(); j++) {
				if (!allocations.contains(j)) {
					iterations++;
					allocations.add(j);
					totalCostSoFar += costMatrix[person][j];
					minCost = getMinCost(costMatrix, person + 1, allocations,
							totalCostSoFar, minCost, result);
					allocations.remove(allocations.size() - 1);
					totalCostSoFar -= costMatrix[person][j];
				}
			}
		}
		return minCost;
	}

	public static void main(String args[]) {
		List<Location> people = new ArrayList<Location>();
//		people.add(new Location(5, 1));
		people.add(new Location(1, 1));
		people.add(new Location(2, 1));
		people.add(new Location(3, 1));
//		people.add(new Location(4, 1));

		List<Location> bikes = new ArrayList<Location>();
		bikes.add(new Location(1, 2));
		bikes.add(new Location(2, 2));
		bikes.add(new Location(3, 2));
//		bikes.add(new Location(4, 2));
//		bikes.add(new Location(5, 2));

		BikesOnMapShortestPath sp = new BikesOnMapShortestPath(people, bikes);
		System.out.println(sp.calculate());
	}

}

class Location {
	double x;
	double y;

	public Location(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
