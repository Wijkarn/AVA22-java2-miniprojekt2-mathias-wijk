package main;

import javax.swing.SwingUtilities;

import view.PrimeNumbersGUI;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new PrimeNumbersGUI().createAndShowGUI());
	}
	
}
