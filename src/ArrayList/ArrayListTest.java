package ArrayList;


public class ArrayListTest {
    public static void main(String[] args) {
        arrayListTest();
    }

    public static void arrayListTest() {

        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("1111");
        myArrayList.add("22222");
        myArrayList.add("aldlaldaldla");
        myArrayList.add("23232");
        myArrayList.remove(1);
        System.out.println(myArrayList);
        System.out.println("myArrayList.get(2) = " + myArrayList.get(2));
    }
}