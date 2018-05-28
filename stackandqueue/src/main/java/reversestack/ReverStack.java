package reversestack;

import java.util.Deque;
import java.util.Stack;

public class ReverStack {

	private static int getAndRemoveLastElement(Deque<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Deque<Integer> stack) throws Exception {
		if (stack == null) {
			throw new Exception("Your Stack is Empty!");
		} else if (stack.isEmpty()) {
			return;
		}
		int last = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(last);
	}

}
