import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input size of an array : ");
		int[] a = new int[sc.nextInt()];

		System.out.println();

		for (int i = 0; i < a.length; i++) {
			System.out.print("Input number [" + (i + 1) + "] : ");
			a[i] = sc.nextInt();
		}

		System.out.println("\nMin difference is " + minDiff(a));
	}

	static int minDiff(int[] d) {
		if(d.length <= 1) {
			return 0;
		}
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < d.length; i++) {
			for (int j = i + 1; j < d.length; j++) {
				int diff = Math.abs(d[i] - d[j]);
				if (diff < minDiff)
					minDiff = diff;
			}
		}
		return minDiff;
	}

}
