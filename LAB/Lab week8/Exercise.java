import java.util.Scanner;

import queue.*;

public class Exercise {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//ArrayQueue AQ = new ArrayQueue(1);
		ArrayQueue table1 = new ArrayQueue(1);
		ArrayQueue table2 = new ArrayQueue(1);
		ArrayQueue table3 = new ArrayQueue(1);
		ArrayQueue table4 = new ArrayQueue(1);

		String again;
		int cus;
		int t;

		showHeader();

		do {
			String LM;
			System.out.print("Choose Service : ");
			String service = scan.nextLine();
			System.out.println(line);
			switch (service) {
			case "1":
				System.out.println(">>[Enqueue (Add)] Service");

				System.out.print("How many person? : ");
				cus = scan.nextInt();
				scan.nextLine();
				while (cus < 1) {
					System.out.print("Customer must not below 1! please input again : ");
					cus = scan.nextInt();
					scan.nextLine();
				}

				System.out.print("Input customer name : ");
				if (cus <= 2) {
					LM = inputCusName();
					table1.enqueue(LM);
					System.out.println("Enqueued : \"" + LM + "\" at Table[1]");
				} else if (cus <= 4) {
					LM = inputCusName();
					table2.enqueue(LM);
					System.out.println("Enqueued : \"" + LM + "\" at Table[2]");
				} else if (cus <= 6) {
					LM = inputCusName();
					table3.enqueue(LM);
					System.out.println("Enqueued : \"" + LM + "\" at Table[3]");
				} else {
					LM = inputCusName();
					table4.enqueue(LM);
					System.out.println("Enqueued : \"" + LM + "\" at Table[4]");
				}

				break;

			case "2":
				System.out.println(">>[Dequeue (Remove)] Service");

				t = selectTable();

				try {
					switch (t) {
					case 1:
						System.out.println("Called customer from Table[1] is \"" + table1.peek() + "\"");
						table1.dequeue();
						break;
					case 2:
						System.out.println("Called customer from Table[2] is \"" + table2.peek() + "\"");
						table2.dequeue();
						break;
					case 3:
						System.out.println("Called customer from Table[3] is \"" + table3.peek() + "\"");
						table3.dequeue();
						break;
					case 4:
						System.out.println("Called customer from Table[4] is \"" + table4.peek() + "\"");
						table4.dequeue();
						break;
					default:
						System.out.println("Table not found!");

					}
				} catch (Exception er) {
					System.err.println("Cannot Dequeue : Object is Empty!\nPlease Enqueue First.");
				}
				break;

			case "3":
				System.out.println(">>[Peek] Service");

				t = selectTable();

				try {
					switch (t) {
					case 1:
						System.out.println("Next customer to be called from Table[1] is \"" + table1.peek() + "\"");
						break;
					case 2:
						System.out.println("Next customer to be called from Table[2] is \"" + table2.peek() + "\"");
						break;
					case 3:
						System.out.println("Next customer to be called from Table[3] is \"" + table3.peek() + "\"");
						break;
					case 4:
						System.out.println("Next customer to be called from Table[4] is \"" + table4.peek() + "\"");
						break;
					default:
						System.out.println("Table not found!");

					}
				} catch (Exception er) {
					System.err.println("Cannot Dequeue : Object is Empty!\nPlease Enqueue First.");
				}
				break;

			case "4":
				System.out.println(">>[Size] Service");

				//t = selectTable();

				System.out.println("  Table[1] : " + getSizeScale(table1) + " (" + table1.size() + ")");
				System.out.println("  Table[2] : " + getSizeScale(table2) + " (" + table2.size() + ")");
				System.out.println("  Table[3] : " + getSizeScale(table3) + " (" + table3.size() + ")");
				System.out.println("  Table[4] : " + getSizeScale(table4) + " (" + table4.size() + ")");

//				switch (t) {
//				case 1:
//					System.out.println("Table[1] have : " + table1.size() + " table(s)");
//					break;
//				case 2:
//					System.out.println("Table[2] have : " + table2.size() + " table(s)");
//					break;
//				case 3:
//					System.out.println("Table[3] have : " + table3.size() + " table(s)");
//					break;
//				case 4:
//					System.out.println("Table[4] have : " + table4.size() + " table(s)");
//					break;
//				default:
//					System.out.println("Table not found!");
//				}
				break;

			case "5":
				System.out.println(">>[isEmpty] Service");

				t = selectTable();

				switch (t) {
				case 1:
					System.out.println("Table[1] is " + (table1.isEmpty() ? "[" : "[not ") + "Empty]");
					break;
				case 2:
					System.out.println("Table[2] is " + (table1.isEmpty() ? "[" : "[not ") + "Empty]");
					break;
				case 3:
					System.out.println("Table[3] is " + (table1.isEmpty() ? "[" : "[not ") + "Empty]");
					break;
				case 4:
					System.out.println("Table[4] is " + (table1.isEmpty() ? "[" : "[not ") + "Empty]");
					break;
				default:
					System.out.println("Table not found!");
				}
				break;

			case "6":
				System.out.println(">>[TotalSize] Service");
				System.out.println("Total occupied tables are : "
						+ (table1.size() + table2.size() + table3.size() + table4.size()) + " table(s)");
				break;

			default:
				System.err.println("Error 404 : Service not Found!");
			}

			System.out.println(line);
			System.out.print("Do it again ? (Y/N) : ");
			again = scan.next();
			scan.nextLine();
			while (!again.equalsIgnoreCase("y") && !again.equalsIgnoreCase("n")) {
				System.out.print("Choose Only (Y/N) : ");
				again = scan.next();
				scan.nextLine();
			}

			System.out.println(line);
		} while (again.equalsIgnoreCase("y"));
		System.out.println("  Thanks for using ArrayQueue System Version 1.1!");
		System.out.println(line2);
	}

	static String line = "---------------------------------------------------";
	static String line2 = "===================================================";

	public static void showHeader() {
		System.out.println(line2);
		System.out.println("\t\tRaan Ded Queue Yaaw");
		System.out.println(line2);
		System.out.println("\t\tChoose Your Service");
		System.out.println(line);
		System.out.println("\t1.) Enqueue (Add)");
		System.out.println("\t2.) Dequeue (Remove)");
		System.out.println("\t3.) Peek (Show first Object in Array)");
		System.out.println("\t4.) Size");
		System.out.println("\t5.) isEmpty");
		System.out.println("\t6.) TotalSize");
		System.out.println(line);
	}

	public static String inputCusName() {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		while (name.isEmpty()) {
			System.out.print("Input customer name, again : ");
			name = scan.nextLine();
		}
		return name;
	}

	public static int selectTable() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\tTable[1] : 1-2 person");
		System.out.println("\tTable[2] : 3-4 person");
		System.out.println("\tTable[3] : 5-6 person");
		System.out.println("\tTable[4] : 7 or more");

		System.out.print("Select table : ");
		int t = scan.nextInt();
		scan.nextLine();

		return t;
	}

	public static String getSizeScale(ArrayQueue t) {
		String scale = "";
		for (int i = 1; i <= t.size(); i++) {
			scale += "|";
		}
		return scale;
	}

}