package edu.aarav.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	
	private Map<Integer, Test> testMap;
	
	{
		testMap = new HashMap<>();
		testMap.put(1, new Test(1, "Avinash"));
		testMap.put(2, new Test(2, "Avi"));
		testMap.put(3, new Test(3, "Aarav"));
	}

	public static void main(String[] args) {
		MapTest tester = new MapTest();
		HashMap<Integer, Test> testMap = (HashMap<Integer, Test>) tester.testMap;

		System.out.println("Before:-");
		for (Test test : testMap.values()) {
			System.out.println(test);
		}
		
		testMap.put(10, new Test(10, "Bablu"));
		
		System.out.println("After:-");
		for (Test test : testMap.values()) {
			System.out.println(test);
		}
		
		
		

	}
}

class Test {
	int id;
	String name;

	public Test() {
	}

	public Test(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + "]";
	}
}
