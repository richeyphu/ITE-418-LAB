public class Test4 {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		int[] a = new int[5];
		int diff = maxDiff(a);
		System.out.print(count);
	}

	static int maxDiff(int[] d) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < d.length; i++) {
			if (d[i] > max)
				max = d[i];
			if (d[i] < min)
				min = d[i];
			count++;
		}
		return max - min;
	}
}