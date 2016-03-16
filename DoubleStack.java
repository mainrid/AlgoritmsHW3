import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class DoubleStack {
	private Stack<Double> stack;

	public static void main(String[] argum) {
		DoubleStack first = new DoubleStack();		
		first.push(3.5);		
		first.push(4.5);
		
		try {
			DoubleStack firstClone = (DoubleStack) first.clone();
			System.out.println(first.equals(firstClone));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DoubleStack.interpret("12. 14. 14. -");

	}

	DoubleStack() {
		this.stack = new Stack<Double>();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		DoubleStack temporary = new DoubleStack();
		DoubleStack clone = new DoubleStack();

		int stackSize = this.stack.size();
		for (int i = 0; i < stackSize; i++) {
			double temp = this.stack.pop();
			temporary.push(temp);
		}
		for (int i = 0; i < stackSize; i++) {
			double temp = temporary.pop();
			clone.push(temp);
			this.stack.push(temp);

		}

		return clone;

	}

	public boolean stEmpty() {
		if (this.stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public void push(double a) {
		this.stack.push(a);

	}

	public double pop() {
		try {
			return this.stack.pop();
		} catch (EmptyStackException e) {
			throw new RuntimeException("pop() method called for empty stack");
		}
	} // pop

	public void op(String s) {
		int elementCounter=0;
		try {			
			double first = this.stack.pop();
			elementCounter++;
			double second = this.stack.pop();

			if (s.equals("+")) {
				push(second + first);
			} else if (s.equals("-")) {
				push(second - first);
			} else if (s.equals("*")) {
				push(second * first);
			} else if (s.equals("/")) {
				push(second / first);
			} else {
				throw new RuntimeException("method \"op\" called with incorrect argument - " + s + ", possible arguments: +,-,*,/");
			}

		} catch (EmptyStackException e) {
			throw new RuntimeException("There is " + elementCounter + " elements in stack, should be at least two when calling \"op\" method");
		}
	}

	public double tos() {
		try {
			return stack.peek();
		} catch (EmptyStackException e) {
			throw new RuntimeException("\"tos\" method called for empty stack");
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof DoubleStack))
			return false;

		DoubleStack other = (DoubleStack) o;
		if (this.stack.equals(other.stack))
			return true;

		return false;
	}

	@Override
	public String toString() {
		if (stEmpty()) {
			return "Stack is empty";
		}

		StringBuffer stackData = new StringBuffer();

		for (int i = 0; i < stack.size(); i++) {
			stackData.append(stack.get(i).toString());
			stackData.append(" ");
		}
		return stackData.toString();

	}

	public int getSize() {
		return this.stack.size();
	}

	public static double interpret(String pol) {
		StringTokenizer splitted = new StringTokenizer(pol);
		String next = "";
		String operators = "+-/*";
		DoubleStack stack = new DoubleStack();
		String currentOperator = "";
		double rpnValue = 0;

		while (splitted.hasMoreTokens()) {
			next = splitted.nextToken();

			if (!operators.contains(next)) {
				try {
					double v = Double.valueOf(next);
					stack.push(v);
				} catch (NumberFormatException e) {
					throw new RuntimeException("Method \"interpret\" argument " + pol + " is not in the correct format. " + next + " cannot be converted to double type. Correct method call example: DoubleStack.interpret(\"2. 15. -\")");
				}

			} else {
				currentOperator = next;
				stack.op(currentOperator);
			}
		}
		rpnValue = stack.pop();
		if (!stack.stEmpty()) {
			throw new RuntimeException("Method \"interpret\" argument " + pol + " has more than 2 convertable to double type numbers. Should be only 2 convertable to double type numbers. Correct method call example: DoubleStack.interpret(\"2. 15. -\") ");
		}
		return rpnValue;
	}

}
