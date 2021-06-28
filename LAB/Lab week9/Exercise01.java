import queue.BinaryHeap;
import queue.PriorityQueue;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue q = new BinaryHeap(10);

		showHeader();

		while (true) {
			try {
				System.out.print("Select service : ");
				String service = sc.nextLine();

				if (service.equalsIgnoreCase("0")) {
					System.out.println(line);
					System.out.println("\t\tThank You and Have a Nice Trip!");
					System.out.println("\t\t            __|__\r\n" + "\t\t     --@--@--(_)--@--@--");
					System.out.println(line);
					break;
				}

				while (!service.equalsIgnoreCase("5") && !service.equalsIgnoreCase("1")
						&& !service.equalsIgnoreCase("2") && !service.equalsIgnoreCase("3")
						&& !service.equalsIgnoreCase("4")) {
					System.out.print("Select service , again : ");
					service = sc.nextLine();
				}

				switch (service) {
				case "1":
					showClass();
					System.out.print("Please input your class : ");
					String ticket = sc.nextLine();

					switch (ticket) {
					case "1":
						System.out.println(">> [First Class] queued!");
						q.enqueue(3);
						break;

					case "2":
						System.out.println(">> [Business Class] queued!");
						q.enqueue(2);
						break;

					case "3":
						System.out.println(">> [Economy Class] queued!");
						q.enqueue(1);
						break;

					default:
						System.out.print("Class not found!");
						break;

					}
					break;

				case "2":
					System.out.println(getClass((int) q.peek()) + " is dequeued!");
					q.dequeue();
					break;

				case "3":
					System.out.println("Size : There are " + q.size() + " customer(s) in queue");
					break;

				case "4":
					System.out.println("isEmpty : There " + (q.isEmpty() ? "is no" : "are") + " customer in queue");
					break;

				case "5":
					System.out.print("Most priority queue is : ");
					System.out.println(getClass((int) q.peek()));
					break;

				}
			} catch (Exception Er) {
				System.err.println("Error : " + Er.toString());
			}

			System.out.println(line2);
		}

	}

	static String line = "=============================================================";
	static String line2 = "-------------------------------------------------------------";

	public static void showHeader() {
		System.out.println(line);
		System.out.println("\t\t     Binary Heap Airline");
		showAirplane();
		System.out.println(line);
		System.out.println(
				"Select services\n\t[1] Enqueue\n\t[2] Dequeue\n\t[3] Size\n\t[4] isEmpty\n\t[5] Peek\n\t[0] End Program");
		System.out.println(line);
	}

	public static void showAirplane() {
		System.out.println("		              |\r\n" + "                              |\r\n"
				+ "                              |\r\n" + "                            .-'-.\r\n"
				+ "                           ' ___ '\r\n" + "                 ---------'  .-.  '---------\r\n"
				+ " _________________________'  '-'  '_________________________\r\n"
				+ "  ''''''-|---|--/    \\==][^',_m_,'^][==/    \\--|---|-''''''\r\n"
				+ "                \\    /  ||/   H   \\||  \\    /\r\n"
				+ "                 '--'   OO   O|O   OO   '--'");
	}

	public static void showClass() {
		System.out.println("\t[1] First Class");
		System.out.println("\t[2] Business Class");
		System.out.println("\t[3] Economy Class");
	}

	public static String getClass(int n) {
		switch (n) {
		case 3:
			return "[First Class]";
		case 2:
			return "[Business Class]";
		case 1:
			return "[Economy Class]";
		}
		return "";
	}

}
