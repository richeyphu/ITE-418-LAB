import java.text.DecimalFormat;
import java.util.Scanner;

import stack.*;

public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayStack credit = new ArrayStack(100);
		ArrayStack score = new ArrayStack(100);

		showHeader();

		int n = 0;
		while (true) {
			System.out.println(">> Subject [" + (++n) + "]");

			System.out.print("Input credit : ");
			credit.push(sc.nextInt());
			// Input credit = 0 for calculate.
			if ((int) credit.peek() == 0) {
				credit.pop();
				n--;
				break;
			}

			System.out.print("Input score  : ");
			score.push(sc.nextFloat());
			while (!isValidScore((float) score.peek())) {
				score.pop();
				System.out.print("Input score, again : ");
				score.push(sc.nextFloat());
			}

			System.out.println(">> Grade = [" + getGrade((float) score.peek()) + "]");

			System.out.println();
		}

		System.out.println(line);

		float sumCxG = 0, sumCredit = 0;
		for (int i = credit.size(); i > 0; i--) {
			sumCxG += (int) credit.peek() * getNumGrade((float) score.peek());
			sumCredit += (int) credit.peek();
			credit.pop();
			score.pop();
		}

		DecimalFormat f = new DecimalFormat("0.00");

		System.out.println("\t     Your GPA is [ " + f.format(sumCxG / sumCredit) + " ]");

		System.out.println(line2);

		sc.close();
		
	}

	static String line = "------------------------------------------------";
	static String line2 = "================================================";

	public static void showHeader() {
		System.out.println(line2);
		System.out.println("\t     GPA Caculation Service");
		System.out.println(line2);
	}

	public static String getGrade(float s) {
		if (s >= 89)
			return "A";
		if (s >= 80)
			return "B+";
		if (s >= 76)
			return "B";
		if (s >= 68)
			return "C+";
		if (s >= 60)
			return "C";
		if (s >= 51)
			return "D+";
		if (s >= 45)
			return "D";
		return "F";
	}

	public static float getNumGrade(float s) {
		if (s >= 89)
			return 4.00f;
		if (s >= 80)
			return 3.50f;
		if (s >= 76)
			return 3.00f;
		if (s >= 68)
			return 2.50f;
		if (s >= 60)
			return 2.00f;
		if (s >= 51)
			return 1.50f;
		if (s >= 45)
			return 1.00f;
		return 0;
	}

	public static boolean isValidScore(float s) {
		return s >= 0 && s <= 100;
	}
}
