package controller;

import java.util.ArrayList;

public class PrimeNumberController {

	// Method to find prime numbers up to a given number 'n'
	public ArrayList<Integer> findPrimesUpToN(int n) {
		// If n is less than 2, there are no prime numbers to find, returning null.
		if (n < 2) {
			return null;
		} else {
			// Create an ArrayList to store prime numbers.
			ArrayList<Integer> primesArray = new ArrayList<>();
			// Start the recursive method
			findPrimesRecursive(2, n, primesArray);
			return primesArray;
		}
	}

	// Recursive method to find prime numbers in a given range
	private void findPrimesRecursive(int current, int n, ArrayList<Integer> primes) {
		// If 'current' exceeds 'n', terminate the recursion.
		if (current > n) {
			return;
		}
		// If 'current' is a prime number, add it to the ArrayList.
		if (isPrime(current)) {
			primes.add(current);
		}
		findPrimesRecursive(current + 1, n, primes);
	}

	// Method to check if a number is prime
	public boolean isPrime(int number) {
		// Numbers less than or equal to 3 are prime (2 and 3).
		if (number <= 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		// Check for divisibility by numbers of the form 6k ± 1, optimizing the primality test.
		for (int i = 5; i * i <= number; i += 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}
		// If none of the above conditions are met, the number is prime.
		return true;
	}
}
