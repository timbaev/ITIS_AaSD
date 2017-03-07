package HW_2march;

/**
 * Created by Timbaev on 02.03.2017.
 * stringMyLinkedList test
 */
public class App {

    public static void main(String[] args) {
        MyLinkedList<String> stringMyLinkedList = new MyLinkedList<>();

        stringMyLinkedList.add("Test");
        stringMyLinkedList.add("ITIS");
        stringMyLinkedList.add("Hello");

        stringMyLinkedList.addAfter("World", "Hello");
        stringMyLinkedList.remove("ITIS");

        for (String astringMyLinkedList : stringMyLinkedList) {
            System.out.println("iterator: " + astringMyLinkedList);
        }

        System.out.println("size: " + stringMyLinkedList.size());
        System.out.println("get(2): " + stringMyLinkedList.get(2));
        System.out.println("has(\"ITIS\"): " + stringMyLinkedList.has("ITIS"));
        System.out.println("has(\"None\"): " + stringMyLinkedList.has("None"));

        MyLinkedList<String> mergerMyLinkedList = new MyLinkedList<>();
        mergerMyLinkedList.add("New");
        mergerMyLinkedList.add("What happened?");
        mergerMyLinkedList.add("Java programming");

        stringMyLinkedList.merge(mergerMyLinkedList);

        for (String astringMyLinkedList : stringMyLinkedList) {
            System.out.println("iterator: " + astringMyLinkedList);
        }
    }
}
