public class Test3 {
	
	public static int count = 0;
	
	public static void main(String[] args) {
		int[] a = new int[5];
		int diff = maxDiff(a);
		System.out.print(count);
	}

	static int maxDiff(int[] d) {
		int maxDiff = 0;
		for (int i = 0; i < d.length; i++) {
			for (int j = i + 1; j < d.length; j++) {
				int diff = Math.abs(d[i] - d[j]);
				if (diff > maxDiff)
					maxDiff = diff;
				count++;
			}
		}
		return maxDiff;
	}
}