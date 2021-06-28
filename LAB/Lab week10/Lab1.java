import java.util.Scanner;

import binaryTree.BSTree;

public class Lab1 {

	public static void main(String[] args) {
		BSTree bs = new BSTree();
		Scanner sc = new Scanner(System.in);

		System.out.println("===============================================");
		System.out.println("          BinaryTree Max Number Finder");
		System.out.println("===============================================");
		System.out.println("Please input a number (input 'c' to calculate)");
		System.out.println("-----------------------------------------------");

		for (int i = 1;; i++) {
			System.out.print("Input number [" + i + "] : ");
			String input = sc.nextLine();

			boolean check = true;
			while (check && !input.equalsIgnoreCase("c")) {
				try {
					bs.add(Double.parseDouble(input));
					check = false;
				} catch (NumberFormatException e) {
					System.out.print("Input number [" + i + "], again : ");
					input = sc.nextLine();
				}
			}
			
			if (input.equalsIgnoreCase("c")) {
				if (i < 6) {
					System.out.println("Please input at least 5 numbers...");
					i--;
				} else {
					System.out.println();
					System.out.println("The max value out off " + --i + " numbers is [" + bs.getMax() + "]");
					break;
				}
			}
		}

		System.out.println("===============================================");
		System.out.println("                  Thank You!");
		System.out.println("===============================================");

		sc.close();
	}

}
