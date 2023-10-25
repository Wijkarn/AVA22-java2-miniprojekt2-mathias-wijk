package view;

import javax.swing.*;

import controller.PrimeNumberController;

import java.awt.*;
import java.util.ArrayList;

public class PrimeNumbersGUI {

	public void createAndShowGUI() {
		int number = 1000;
		JFrame frame = new JFrame("Prime Numbers");
		JLabel primeLabel = new JLabel("Prime numbers up to " + number + ": ");
		JTextArea primeTextArea = new JTextArea(20, 40);
		PrimeNumberController primeClass = new PrimeNumberController();

		ArrayList<Integer> primeNumberArray = primeClass.findPrimesUpToN(number);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(primeLabel, BorderLayout.NORTH);

		primeTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		primeTextArea.setLineWrap(true);
		primeTextArea.setWrapStyleWord(true);
		primeTextArea.setEditable(false);

		frame.add(new JScrollPane(primeTextArea), BorderLayout.CENTER);
		StringBuilder primeNumbersText = new StringBuilder();

		if (primeNumberArray != null) {
			for (int i = 0; i < primeNumberArray.size(); i++) {
				primeNumbersText.append(primeNumberArray.get(i));
				if (i < primeNumberArray.size() - 1) {
					primeNumbersText.append(", ");
				}
			}
			primeNumbersText.append(" | Number of primes: " + primeNumberArray.size());

		} else {
			primeNumbersText.append(" | NO PRIMES TO DISPLAY | ");
		}

		primeTextArea.setText(primeNumbersText.toString());
		frame.setSize(1400, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
