package recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(-2);
        stack.push(12);
        stack.push(3);
        stack.push(0);
        stack.push(3);
        stack.push(16);
        stack.push(-8);
        stack.push(4);
        stack.push(3);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
    private static void reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int x = stack.pop();
        reverse(stack);
        adder(stack,x);

    }
    private static void adder(Stack<Integer> stack , int x){
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int z = stack.pop();
        adder(stack,x);
        stack.push(z);
    }
}
