import java.util.Scanner;

public class TestCollection2 {

	public static void main(String[] args) {

		Collection c = new ArrayCollection(100);
		Scanner sc = new Scanner(System.in);

		String service;
		Object input;

		while (true) {
			System.out.print("Choose Service : ");
			service = sc.nextLine().toLowerCase();

			if (isServiceValid(service) == 0) {
				System.out.print("Input : ");
				service(service, sc.nextLine(), c);
			} else if (isServiceValid(service) == 1) {
				service(service, null, c);
			} else {
				System.out.println("ERROR: Service is not found!");
			}

			System.out.print("Do it again? (y|n) : ");
			if (!sc.next().equalsIgnoreCase("y")) {
				System.out.println("Thank you!");
				break;
			}

			System.out.println();
			sc.nextLine();
		}

	}

	public static void service(String s, Object input, Collection c) {
		switch (s) {
		case "add":
			c.add(input);
			System.out.println("[" + input + "] Added!");
			break;
		case "remove":
			if (c.contains(input)) {
				c.remove(input);
				System.out.println("[" + input + "] Removed!");
			} else {
				System.out.println("ERROR: [" + input + "] is not found!");
			}
			break;
		case "isEmpty":
			System.out.println(c.isEmpty());
			break;
		case "contains":
			System.out.println("[" + input + "] is" + (c.contains(input) ? "" : "not") + " found!");
			break;
		case "size":
			System.out.println("Current stock is " + c.size());
			break;
		}
	}

	public static int isServiceValid(String s) {
		switch (s) {
		case "add":
		case "remove":
		case "contains":
			return 0;
		case "isEmpty":
		case "size":
			return 1;
		}
		return -1;
	}

}
