package edu.aarav.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nth no is: ");
		int n = in.nextInt();
		long startTime = System.currentTimeMillis();
		// System.out.println(n+"th Fibonacci no is: "+fib(n));
		 System.out.println(n + "th Fibonacci no is: " + fibDP_pro(n));
		//System.out.println(n + "th Fibonacci no is: " + fibonacci(n));
		long endTime = System.currentTimeMillis();
		System.out.println("Total time elapsed: " + (endTime - startTime) + " millis.");

		in.close();
	}

	/*
	 * This program calculate fibonacci number at nth index using Recursive
	 * method call. This is a very costly to memory. It's Time complexity is as
	 * follows:- T(n) = T(n-1) + T(n-2) + 1 = 2^n = O(2^n) NOTE:- Strictly not
	 * applicable on large scale.
	 */
	public static long fib(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	/*
	 * This function also built on recursion method. But time complexity is very
	 * less. i.e., produce very fast calculation even for a big number. Cause it
	 * stores results of its sub-problem in a map use which lead not to
	 * calculate same problem from the next time. Time complexity: T(n) = O(n)
	 * But, there are two problems,
	 *  1. Even when we are saving the result to a
	 * map to reuse them later, we still need to go all the way down to the base
	 * case with the recursion. And also to check the availability of a value,
	 * which may be available or may not be. 
	 * 	2) As with any recursive algorithm, each recursive call takes up
	 * some space on the stack. And, if we have enough of those recursive calls,
	 * the stack will eventually blow up throwing a StackOverflowException. And
	 * this is precisely what happens with our second method when we use values
	 * over 10000
	 */
	public static long fibonacci(int n) {
		Map<Integer, Long> fibMap = new HashMap<Integer, Long>();
		fibMap.put(0, 0L);
		fibMap.put(1, 1L);
		return fibonacci(n, fibMap);
	}

	// this is the helper method.
	private static long fibonacci(int n, Map<Integer, Long> fibMap) {
		if (fibMap.containsKey(n)) {
			return fibMap.get(n);
		}
		fibMap.put(n - 1, fibonacci(n - 1, fibMap));
		fibMap.put(n - 2, fibonacci(n - 2, fibMap));
		long fibOfN = fibMap.get(n - 1) + fibMap.get(n - 2);
		fibMap.put(n, fibOfN);
		return fibOfN;
	}

	/*
	 * This function calculate fibonacci number at nth index by Dynamic
	 * Programming. Store the sub-problems result so that you don’t have to
	 * calculate again( this is called 'Memoization'). So first check if
	 * solution is already available, if yes then use it else calculate and
	 * store it for future. It's is very fast and its time complexity is :- Time
	 * Complexity: T(n) = O(n)
	 * NOTE: - This is the fastest and less 
	 */
	public static long fibDP(int x) {
		long fib[] = new long[x + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < x + 1; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[x];
	}
	/*
	 * We can eliminate array, as we can see only need to track
	 * only last two element not all the elements
	 * Eg. first 10 fibonacci: 0 1 1 2 3 5 8 13 21 34 55
	 */
	public static long fibDP_pro(int x) {
		long n1 = 0;
		long n2 = 1;
		long current = (x == 0 ? 0 : n1 + n2);
		for (int i = 2; i < x + 1; i++) {
			current = n2 + n1;
			n1 = n2;
			n2 = current;
		}
		return current;
	}

}
