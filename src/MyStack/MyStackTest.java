package MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<String>();
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.remove(2);
        System.out.println(myStack);
        System.out.println("myStack.peek() = " + myStack.peek());
        System.out.println("myStack.pop() = " + myStack.pop());
        System.out.println(myStack);
        myStack.clear();
        System.out.println(myStack);
    }
}