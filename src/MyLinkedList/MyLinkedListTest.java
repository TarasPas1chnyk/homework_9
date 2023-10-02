package MyLinkedList;

public class MyLinkedListTest {


    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(2));
        myLinkedList.remove(2);
        System.out.println( myLinkedList.get(2));;
        System.out.println("myLinkedList.size() = " + myLinkedList.size());
        myLinkedList.clear();
        System.out.println(myLinkedList);


    }
}