import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input an initialize number : ");
		int n = sc.nextInt();

		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("n\t\tn^2\t\tMultiplier");
		System.out.println("------------------------------------------");

		int temp = 1;
		for (int i = 1; i <= 256; i *= 2) {
			int d = n * i;
			int s = d * d;
			System.out.println(d + "\t\t" + s + "\t\t" + (i == 1 ? "" : s / temp));
			temp = s;
		}
	}

}
