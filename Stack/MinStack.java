import java.util.Stack;

public class MinStack { private Stack<Integer> stack; private Stack<Integer> minStack;

public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
}

public void push(int val) {
    stack.push(val);
    if (minStack.isEmpty() || val <= minStack.peek()) {
        minStack.push(val);
    }
}

public void pop() {
    if (stack.pop().equals(minStack.peek())) {
        minStack.pop();
    }
}

public int top() {
    return stack.peek();
}

public int getMin() {
    return minStack.peek();
}

public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(3);
    minStack.push(4);
    minStack.push(2);
    minStack.push(1);
    System.out.println("Top: " + minStack.top());
    System.out.println("Min: " + minStack.getMin());
    minStack.pop();
    System.out.println("Top: " + minStack.top());
    System.out.println("Min: " + minStack.getMin());
}

}
