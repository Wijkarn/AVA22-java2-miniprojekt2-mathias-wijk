package controller;

import java.util.ArrayList;

public class PrimeNumberController {

	public ArrayList<Integer> findPrimesUpToN(int n) {
		if (n < 2) {
			return null;
		} else {
			ArrayList<Integer> primesArray = new ArrayList<>();
			findPrimesRecursive(2, n, primesArray);
			return primesArray;
		}
	}

	private void findPrimesRecursive(int current, int n, ArrayList<Integer> primes) {
		if (current > n) {
			return;
		}
		if (isPrime(current)) {
			primes.add(current);
		}
		findPrimesRecursive(current + 1, n, primes);
	}

	public boolean isPrime(int number) {
		if (number <= 3) {
			return true;
		}
		if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= number; i += 6) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}
