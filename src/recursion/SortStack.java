package recursion;

import java.util.Stack;

public class SortStack {
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
        System.out.println(sort(stack));
    }
    public static  Stack<Integer> sort(Stack<Integer> s)
    {
        if(s.size()==1)
            return s;
        int x = s.pop();
        sort(s);
        Stack<Integer> temp = new Stack<>();
        while(!s.isEmpty() && s.peek()>x)
            temp.push(s.pop());
        s.push(x);
        while(!temp.isEmpty())
            s.push(temp.pop());
        return s;
    }
}
