package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxPopulation {

	ArrayList<Person> people = new ArrayList<Person>();

	public MaxPopulation(ArrayList<Person> people) {
		super();
		this.people = people;
	}

	// O(P+PY) => O(PY)
	public int getMaxPopulationYear2() {
		HashMap<Integer, Integer> popMap = new HashMap<Integer, Integer>();

		for (Person person : people) {
			popMap.put(person.birth, 0);
		}

		int maxYear = -1;
		int maxPop = -1;

		for (int year : popMap.keySet()) {
			for (Person person : people) {
				if (year >= person.birth && year < person.death) {
					int newPop = popMap.get(year) + 1;
					popMap.put(year, newPop);
					if (newPop > maxPop) {
						maxPop = newPop;
						maxYear = year;
					}
				} else if (person.death < year) {
					int newPop = popMap.get(year) - 1;
					popMap.put(year, newPop);
				}
			}
		}

		System.out.println(popMap);
		return maxYear;
	}

	// O(P+P+Y) => O(P+Y)
	public int getMaxPopulationYear3() {
		int minYear = 2018;
		int maxYear = 0;

		for (Person person : people) {
			if (person.birth < minYear) {
				minYear = person.birth;
			}
			if (person.birth > maxYear) {
				maxYear = person.death;
			}
		}

		int[] yearMap = new int[maxYear - minYear + 1];

		for (Person person : people) {
			yearMap[person.birth - minYear]++;
			int deathIndex = person.death - minYear;
			if (deathIndex < yearMap.length)
				yearMap[deathIndex]--;
		}

		int maxPopulation = 0;
		int maxPopYear = 0;
		int popSoFar = 0;

		for (int year = 0; year < yearMap.length; year++) {
			popSoFar += yearMap[year];
			if (popSoFar > maxPopulation) {
				maxPopulation = popSoFar;
				maxPopYear = year + minYear;
			}
		}

		System.out.println(Arrays.toString(yearMap));
		return maxPopYear;
	}

	// O(P+PY+Y) => O(PY)
	public int getMaxPopulationYear() {
		int minYear = 2018;
		int maxYear = 0;
		int maxPopulation = 0;
		int maxPopYear = 0;

		for (Person person : people) {
			if (person.birth < minYear) {
				minYear = person.birth;
			}
			if (person.death > maxYear) {
				maxYear = person.death;
			}
		}

		int[] yearMap = new int[maxYear - minYear + 1];

		for (Person person : people) {
			for (int year = person.birth; year < person.death; year++) {
				yearMap[year - minYear]++;
			}
		}

		for (int year = 0; year < yearMap.length; year++) {
			if (yearMap[year] > maxPopulation) {
				maxPopulation = yearMap[year];
				maxPopYear = year + minYear;
			}
		}

		System.out.println(Arrays.toString(yearMap));
		return maxPopYear;
	}

	public static void main(String args[]) {
		Person p1 = new Person("p1", 1970, 1976);
		Person p2 = new Person("p2", 1973, 1981);
		Person p3 = new Person("p3", 1974, 1978);
		Person p4 = new Person("p4", 1974, 1978);
		Person p5 = new Person("p5", 1977, 1980);
		ArrayList<Person> people = new ArrayList<Person>();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		MaxPopulation m = new MaxPopulation(people);
		System.out.println("year = " + m.getMaxPopulationYear());
		System.out.println("year = " + m.getMaxPopulationYear2());
		System.out.println("year = " + m.getMaxPopulationYear3());
	}
}

class Person {
	String name;
	int birth;
	int death;

	public Person(String name, int birth, int death) {
		super();
		this.name = name;
		this.birth = birth;
		this.death = death;
	}
}
