import java.util.Scanner;

import stack.*;

public class checkParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Input a message : ");
		System.out.println(
				"This message has [" + (checkParentheses(sc.nextLine()) ? "correct" : "incorrect") + "] parentheses");
	}

	public static boolean checkParentheses(String t) {
		String open = "{([", close = "})]";
		Stack s = new ArrayStack(100);
		for (int i = 0; i < t.length(); i++) {
			String token = t.substring(i, i + 1);
			if (open.indexOf(token) >= 0) {
				s.push(token);
			} else {
				int k = close.indexOf(token);
				if (k >= 0)
					if (s.isEmpty() || !open.substring(k, k + 1).equals(s.pop()))
						return false;
			}
		}
		return s.isEmpty();
	}
}
