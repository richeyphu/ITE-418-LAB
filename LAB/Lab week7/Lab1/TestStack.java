import stack.ArrayStack;
import stack.Stack;

public class TestStack {

	public static void main(String[] args) {
		Stack s = new ArrayStack(1);
		System.out.println(s.isEmpty());
		s.push("A");
		s.push("B");
		s.push("C");
		s.pop();
		System.out.println(s.size());
		System.out.println(s.peek());
	}

}
