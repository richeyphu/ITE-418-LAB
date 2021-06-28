import java.text.DecimalFormat;
import java.util.Scanner;

import List.ArrayList;

public class Exercise01 {

	public static void main(String[] args) {

		ArrayList al = new ArrayList(1);
		Scanner sc = new Scanner(System.in);

		showHeader();

		while (true) {
			int service;
			int input, index;

			System.out.print("Enter service number : ");
			service = sc.nextInt();
			sc.nextLine();

			if (service == 0) {
				checkout(toArray(al));
				break;
			}

			switch (service) {
			case 1:
				System.out.println("[Add] Service");
				showMenu();

				System.out.print("Input your order : ");
				input = sc.nextInt();
				sc.nextLine();
				if (getMenu(input).equals("")) {
					System.out.println("ERROR: Menu is not found!");
					break;
				}
				al.add(getMenu(input));
				System.out.println("Menu [" + getMenu(input) + "] added!");

				break;

			case 2:
				System.out.println("[Remove] Service");

				System.out.print("Input your menu : ");
				input = sc.nextInt();
				sc.nextLine();
				if (getMenu(input).equals("")) {
					System.out.println("ERROR: Menu is not found!");
					break;
				}
				al.remove(getMenu(input));
				System.out.println("Menu [" + getMenu(input) + "] removed!");

				break;

			case 3:
				System.out.println("[Get] Service");

				System.out.print("Input [INDEX] to get your menu : ");
				index = sc.nextInt();
				sc.nextLine();
				System.out.println("Your order is [" + al.get(index) + "]");

				break;

			case 4:
				System.out.println("[Set] Service");

				System.out.print("Input [INDEX] to set your new menu : ");
				index = sc.nextInt();
				sc.nextLine();
				System.out.println("You select Index : [" + index + "]");
				System.out.print("Input your new menu : ");
				input = sc.nextInt();
				sc.nextLine();
				al.set(index, getMenu(input));
				System.out.println("Index [" + index + "] had been set to \"" + getMenu(input) + "\"");

				break;

			case 5:
				System.out.println("[indexOf] Service");

				System.out.print("Input your menu number to check in the cart : ");
				input = sc.nextInt();
				sc.nextLine();
				System.out.println("Your menu " + (al.indexOf(getMenu(input)) == -1 ? "is not found"
						: "(" + getMenu(input) + ") is found in index [" + al.indexOf(getMenu(input)) + "]"));
				break;

			default:
				System.out.println("ERROR: Service is not Found!, Please try again...");
			}

			System.out.println();
		}

		sc.close();
	}

	static String line = "----------------------------------------------------";
	static String line2 = "====================================================";

	public static void showHeader() {
		System.out.println(line2);
		System.out.println("\t         KFC Fried Chicken");
		System.out.println(line2);
		System.out.println("\t\tChoose Your Service");
		System.out.println(line);
		System.out.println("\t[1] Add\n\t[2] Remove\n\t[3] Get\n\t[4] Set\n\t[5] indexOf\n\t[0] Check Out");
		System.out.println(line);
	}

	public static void showMenu() {
		System.out.println("\t[1] " + getMenu(1) + "\t39 B.");
		System.out.println("\t[2] " + getMenu(2) + "\t59 B.");
		System.out.println("\t[3] " + getMenu(3) + "\t85 B.");
		System.out.println("\t[4] " + getMenu(4) + "\t\t\t24 B.");
		System.out.println("\t[5] " + getMenu(5) + "\t\t19 B.");
		System.out.println("\t[6] " + getMenu(6) + "\t\t45 B.");
	}

	public static String getMenu(int m) {
		switch (m) {
		case 1:
			return "Hot and Spicy Fried Chicken";
		case 2:
			return "Spicy Chicken Rice Bowl";
		case 3:
			return "Double Cheese Zinger Burger";
		case 4:
			return "Egg Tart";
		case 5:
			return "Pepsi 300 ml";
		case 6:
			return "Large Mashed Potato";
		}
		return "";
	}

	public static int getPrice(String m) {
		switch (m) {
		case "Hot and Spicy Fried Chicken":
			return 39;
		case "Spicy Chicken Rice Bowl":
			return 59;
		case "Double Cheese Zinger Burger":
			return 85;
		case "Egg Tart":
			return 24;
		case "Pepsi 300 ml":
			return 19;
		case "Large Mashed Potato":
			return 45;
		}
		return 0;
	}

	public static String[] toArray(ArrayList al) {
		String[] a = new String[al.size()];
		for (int i = 0; i < al.size(); i++) {
			a[i] = (String) al.get(i);
		}
		return a;
	}

	public static void checkout(String[] a) {
		System.out.println();
		System.out.println(line2);
		System.out.println("\t\t   [Check Out]");
		System.out.println(line);

		int total = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.println(">> [" + (i + 1) + "] " + getPrice(a[i]) + " B.\t" + a[i] + "\t\t");
			total += getPrice(a[i]);
		}

		DecimalFormat f = new DecimalFormat("#,##0.00");
		System.out.println("\n>> Total price is " + f.format(total) + " B.");

		System.out.println(line);
		System.out.println("     Thank You for using KFC ArrayList Edition!");
		System.out.print(line2);
	}
}
