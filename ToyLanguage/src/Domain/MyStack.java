package Domain;

public class MyStack <T> implements MyIStack<T>{
    java.util.Stack<T> stack;

    public MyStack() {
        stack = new java.util.Stack<T>();
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T v) {
        stack.push(v);
    }

    @Override
    public String toString() {
        return stack.toString();
    }
    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }

}
