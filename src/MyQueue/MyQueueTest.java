package MyQueue;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<String>();
        myQueue.add("a");
        myQueue.add("b");
        myQueue.add("c");
        System.out.println(myQueue);
        System.out.println("myQueue.peek() = " + myQueue.peek());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        System.out.println("myQueue.poll() = " + myQueue.poll());
        myQueue.clear();
        System.out.println(myQueue);

    }
}