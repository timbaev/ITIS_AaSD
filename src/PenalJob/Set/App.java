package PenalJob.Set;

import HW_2march.MyLinkedList;

import java.util.Arrays;

/**
 * Created by Timbaev on 15.03.2017.
 * Test Set
 */
public class App {

    public static void main(String[] args) {
        MySet<String> mySet = new MySet<>();
        mySet.add("Test");
        mySet.add("World");
        mySet.add("Hello");
        System.out.println("Size: " + mySet.size());
        System.out.println("IsEmpty: " + mySet.isEmpty());
        System.out.println("Contains: " + mySet.contains("Test"));
        System.out.println("ToArray: " + Arrays.toString(mySet.toArray()));
        System.out.println("ToArray (contains): " + Arrays.toString(mySet.toArray(new String[] {"Test", "Hello"})));
        //mySet.remove("Hello");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("None");
        myLinkedList.add("World");
        System.out.println("ContainsAll: " + mySet.containsAll(myLinkedList));

        for (String title : mySet) {
            System.out.println("Iterator: " + title);
        }
    }
}
