package HW_2march;

/**
 * Created by Timbaev on 02.03.2017.
 * stringMyLinkedList test
 */
public class App {

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Hello");
        myLinkedList.add("World");
        myLinkedList.add("myLinkedList");
        myLinkedList.add("ITIS");
        myLinkedList.addAfter("World", "ITIS");
        myLinkedList.remove("ITIS");
        System.out.println("Get: " + myLinkedList.get(1));
        System.out.println("Has: " + myLinkedList.has("Hello"));
        MyLinkedList<String> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.add("New Test");
        myLinkedList1.add("New ITIS");
        myLinkedList1.add("New Hello");
        myLinkedList.merge(myLinkedList1);

        for (String aMyLinkedList : myLinkedList) {
            System.out.println("Iterator: " + aMyLinkedList);
        }

        System.out.println("_____________________________________________________");

        MyDoublyLinkedList<String> myDoublyLinkedList = new MyDoublyLinkedList<>();
        myDoublyLinkedList.add("Hello");
        myDoublyLinkedList.add("World");
        myDoublyLinkedList.add("ITIS");
        myDoublyLinkedList.addAfter("After World", "World");
        myDoublyLinkedList.remove("World");
        System.out.println("Get: " + myDoublyLinkedList.get(1));
        System.out.println("Has: " + myDoublyLinkedList.has("ITIS"));
        MyDoublyLinkedList<String> myDoublyLinkedList1 = new MyDoublyLinkedList<>();
        myDoublyLinkedList1.add("New Hello");
        myDoublyLinkedList1.add("New World");
        myDoublyLinkedList1.add("New ITIS");
        myDoublyLinkedList.merge(myDoublyLinkedList1);
        System.out.println("Size: " + myDoublyLinkedList.size());

        for (String title : myDoublyLinkedList) {
            System.out.println("Iterator: " + title);
        }
    }
}
