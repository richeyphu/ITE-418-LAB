import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input size of an array : ");
		int[] a = new int[sc.nextInt()];

		System.out.println();
		
		for (int i = 0; i < a.length; i++) {
			System.out.print("Input number [" + (i + 1) + "] : ");
			a[i] = sc.nextInt();
		}
		
		System.out.println("\nMax difference is " + maxDiff(a));
	}

	static int maxDiff(int[] d) {
		if(d.length <= 1) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < d.length; i++) {
			if (d[i] > max)
				max = d[i];
			if (d[i] < min)
				min = d[i];
		}
		return max - min;
	}

}
