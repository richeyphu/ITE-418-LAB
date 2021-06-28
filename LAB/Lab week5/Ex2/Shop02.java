import java.util.Scanner;

public class Shop02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LinkedCollectionWithHeader lc = new LinkedCollectionWithHeader();

		showHeader();
		showOptions();

		while (true) {
			System.out.print("Input a number : ");

			int opt = sc.nextInt();
			String t;

			if (opt == 0) {
				showFooter();
				break;
			}

			switch (opt) {
			case 1:
				System.out.print("Input an item : ");
				sc.nextLine();
				t = sc.nextLine();
				lc.add(t);
				System.out.println("[" + t + "] ADDED!");
				break;

			case 2:
				System.out.print("Input an item : ");
				sc.nextLine();
				t = sc.nextLine();
				if (lc.contains(t)) {
					lc.remove(t);
					System.out.println("[" + t + "] REMOVED!");
				} else {
					System.out.println("[" + t + "] IS NOT EXIST!");
				}
				break;

			case 3:
				System.out.println("STOCK IS" + (lc.isEmpty() ? " " : " NOT ") + "EMPTY");
				break;

			case 4:
				System.out.print("Input an item : ");
				sc.nextLine();
				t = sc.nextLine();
				System.out.println("[" + t + "] IS" + (lc.contains(t) ? " " : " NOT ") + "EXIST");
				break;

			case 5:
				System.out.println("CURRENT STOCK IS [" + lc.size() + "]");
				break;

			case 6:
				System.out.println("THERE IS [" + lc.size() + "] ITEM" + (lc.size() > 0 ? "S" : "") + " IN STOCK");

				Object[] stock = lc.toArray();
				for (int i = stock.length - 1; i >= 0; i--) {
					System.out.println(">> " + (stock.length - i) + ") [" + stock[i] + "]");
				}
				break;

			default:
				System.out.println("ERROR: PLEASE INPUT ONLY 0-5");
				break;
			}

			System.out.println();

		}

		sc.close();

	}

	private static String line = "===================================";

	public static void showHeader() {
		System.out.println(line);
		System.out.println("||    WELCOME TO MY SHOP 2.0!\t ||");
		System.out.println(line);
	}

	public static void showOptions() {
		System.out.println("   PLEASE SELECT OUR SERVICES");
		System.out.println("     [1] ADD AN ITEM");
		System.out.println("     [2] REMOVE AN ITEM");
		System.out.println("     [3] IS STOCK EMPTY");
		System.out.println("     [4] IS ITEM EXIST");
		System.out.println("     [5] HOW MANY ITEM IN STOCK");
		System.out.println("     [6] LIST ALL ITEM IN STOCK");
		System.out.println("     [0] END PROGRAM");
		System.out.println(line);
	}
	
	public static void showFooter() {
		System.out.println(line);
		System.out.println("\t    THANK YOU!");
		System.out.println(line);
	}
	
}
