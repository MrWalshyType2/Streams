package com.qa.exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class App {
	public static void main(String args[]) {
		// Generate numbers from 1 to 9
		System.out.println(IntStream.range(1, 9)
				.mapToObj(String::valueOf)
				.collect(Collectors.toList()));
		////////////////////////////////////////////////////////////
		// Print all names with "Hello " before, except James.
		////////////////////////////////////////////////////////////
		List<String> names = Arrays.asList("Michael", "Dean", "James", "Chris");
		List<String> helloNames = names.stream()
				.filter(name -> !name.equals("James"))
				.map(name -> "Hello " + name)
				.collect(Collectors.toList());
		
		System.out.println(helloNames);
		
		////////////////////////////////////////////////////////////
		// Reduce the following Integer List to its product (all nums multiplied together)
		////////////////////////////////////////////////////////////
		List<Integer> numbers = Arrays.asList(3, 4, 7, 8, 12);
		System.out.println("Numbers: " + numbers);
		int product = numbers.stream()
				.reduce((num1, num2) -> num1 * num2)
				.get();
		System.out.println("Product: " + product);
		
		////////////////////////////////////////////////////////////
		// Find max
		////////////////////////////////////////////////////////////
		int max = numbers.stream()
				.max(Comparator.comparing(Integer::valueOf))
				.get();
		
		int maxAlt = numbers.stream()
				.max((num, nextNum) -> num.compareTo(nextNum))
				.get();
		
		System.out.println("Max: " + max + "\nMaxAlt: " + maxAlt);
		
		////////////////////////////////////////////////////////////
		// Find min
		////////////////////////////////////////////////////////////
		int min = numbers.stream()
				.min((num, nextNum) -> num.compareTo(nextNum))
				.get();
		
		int minAlt = numbers.stream()
				.min(Comparator.comparing(Integer::valueOf))
				.get();
		
		System.out.println("Min: " + min);
		System.out.println("Min Alt: " + minAlt);
		
		////////////////////////////////////////////////////////////
		// Remove odds
		////////////////////////////////////////////////////////////
		List<Integer> onlyEven = numbers.stream()
				.filter(num -> num % 2 == 0)
				.collect(Collectors.toList());
		
		System.out.println("Only even" + onlyEven);
		
		////////////////////////////////////////////////////////////
		// Remove evens
		////////////////////////////////////////////////////////////
		List<Integer> onlyOdd = numbers.stream()
				.filter(num -> num % 2 == 1)
				.collect(Collectors.toList());
		
		System.out.println("Only odd" + onlyOdd);
		
		////////////////////////////////////////////////////////////
		// Sum of list
		////////////////////////////////////////////////////////////
		int sum = numbers.stream()
				.reduce((num, nextNum) -> num + nextNum)
				.get();
		
		System.out.println("Sum of list: " + sum);
		
		////////////////////////////////////////////////////////////
		// Square every num, then remove even, then find min value
		////////////////////////////////////////////////////////////
		List<Integer> squaredNums = numbers.stream()
				.map(num -> num * num)
				.collect(Collectors.toList());
		
		List<Integer> oddNums = squaredNums.stream()
				.filter(num -> num % 2 == 1)
				.collect(Collectors.toList());
				
		int minOfSquared = oddNums.stream()
				.min((num, nextNum) -> num.compareTo(nextNum))
				.get();
		
		System.out.println("Min of Squared: " + minOfSquared);
		
		int minOfSquaredAlt = numbers.stream()
				.map(num -> num * num)
				.filter(num -> num % 2 == 1)
				.min((num, nextNum) -> num.compareTo(nextNum))
				.get();
		
		System.out.println("Min of Squared Alt: " + minOfSquaredAlt);
		
		////////////////////////////////////////////////////////////
		// Printing all nums in a num list
		////////////////////////////////////////////////////////////
		System.out.println("Nums in list printed: ");
		numbers.stream().forEach(num -> System.out.println(num));
	}
}
