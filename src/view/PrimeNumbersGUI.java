package view;

import javax.swing.*;
import controller.PrimeNumberController;
import java.awt.*;
import java.util.ArrayList;

public class PrimeNumbersGUI {

	public void createAndShowGUI() {
		// Creates all variables/objects
		int number = 1000;
		JFrame frame = new JFrame("Prime Numbers");
		JLabel primeLabel = new JLabel("Prime numbers up to " + number + ": ");
		JTextArea primeTextArea = new JTextArea(20, 40);
		PrimeNumberController primeClass = new PrimeNumberController();
		StringBuilder primeNumbersText = new StringBuilder();
		ArrayList<Integer> primeNumberArray = primeClass.findPrimesUpToN(number);

		// Setting close operation, layout and adds title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(primeLabel, BorderLayout.NORTH);

		// Text area options
		primeTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		primeTextArea.setLineWrap(true);
		primeTextArea.setWrapStyleWord(true);
		primeTextArea.setEditable(false);

		// Adds scrollable text area to the center
		frame.add(new JScrollPane(primeTextArea), BorderLayout.CENTER);

		if (primeNumberArray != null) {
			for (int i = 0; i < primeNumberArray.size(); i++) {
				// Adds primes number to text
				primeNumbersText.append(primeNumberArray.get(i));
				// Adds a comma between the prime numbers
				if (i < primeNumberArray.size() - 1) {
					primeNumbersText.append(", ");
				}
			}
			// Displays the numbers of primes
			primeNumbersText.append(" | Number of primes: " + primeNumberArray.size());

		} else {
			// Display message if no prime numbers were found
			primeNumbersText.append(" | NO PRIMES TO DISPLAY | ");
		}

		// Sets text
		primeTextArea.setText(primeNumbersText.toString());

		// Sets size, location and visibility
		frame.setSize(1400, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
