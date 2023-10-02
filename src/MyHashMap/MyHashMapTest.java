package MyHashMap;

public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("1", 1);
        myHashMap.put("2", 2);
        myHashMap.put("3", 3);
        myHashMap.put("4", 4);
        myHashMap.put("5", 5);
        myHashMap.put("6", 6);
        System.out.println("myHashMap = " + myHashMap);
        System.out.println("myHashMap.get(1) = " + myHashMap.get("1"));
        myHashMap.remove("1");
        System.out.println("myHashMap = " + myHashMap);
        myHashMap.clear();
        System.out.println("myHashMap = " + myHashMap);
    }
}