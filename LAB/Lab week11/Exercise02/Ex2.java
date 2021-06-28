import java.util.Scanner;

import bst.BSTree;

public class Ex2 {
	public static void main(String[] args) {
		BSTree score = new BSTree();
		Scanner sc = new Scanner(System.in);

		System.out.println("============================================");
		System.out.println("    Fast Typing : The Ultimate Knock Out");
		System.out.println("============================================");

		String[] words = { "the", "quick", "brown", "fox", "jumps", "over", "lazy", "dog", "apple", "Thailand",
				"return", "data", "java", "integer", "double", "Japanese" };
		int min = 0;
		int max = 15;

		while (true) {
			System.out.print("Are you ready ? (Y) : ");
			sc.nextLine();
			System.out.println("--------------------------------------------");

			double start = System.currentTimeMillis();

			for (int i = 1; i <= 5; i++) {
				int randomNum = (int) ((Math.random() * ((max - min) + 1)) + min);
				String word = words[randomNum];
				System.out.print("[" + i + "] " + word + "\n>> ");
				String input = sc.nextLine();

				while (!input.equals(word)) {
					System.out.print("Try again >> ");
					input = sc.nextLine();
				}

				System.out.println();
			}

			double end = System.currentTimeMillis();
			double result = (end - start) / 1000;
			score.add(result);

			System.out.println("--------------------------------------------");
			System.out.println(
					"Result : " + result + " seconds! " + (result > (double)score.getMin() ? "" : "[New Record!]"));
			System.out.println("============================================");

			System.out.print("Play again ? (Y/N) : ");
			if (sc.nextLine().equalsIgnoreCase("N")) {
				break;
			}
		}

		System.out.println("============================================");
		System.out.println("                 Scoreboard");
		System.out.println("--------------------------------------------");
		int size = score.size();
		for (int i = 0; i < size; i++) {
			System.out.println("\t[" + (i + 1) + "] " + score.getMin() + " s");
			score.remove(score.getMin());
		}
		System.out.println("============================================");

	}
}
