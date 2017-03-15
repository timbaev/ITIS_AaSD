package HW_2march;

/**
 * Created by Timbaev on 02.03.2017.
 * stringMyLinkedList test
 */
public class App {

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Gitler");
        myLinkedList.add("Caput");
        myLinkedList.add("azazaza");
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
    }
}
