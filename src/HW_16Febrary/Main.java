package HW_16Febrary;

import HW_16Febrary.map.ArrayMap;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Timbaev on 16.02.2017.
 * Main app
 */
public class Main {

    public static void main(String[] args) {
        ArrayMap<String, Integer> map = new ArrayMap<>();

        for (int i = 0; i < 5; i++) {
            map.add("Number " + i, i);
        }

        map.remove("Number 3");
        int number = map.get("Number 2");
        map.set("Number 1", 10);
        String[] keys = map.getKeyes();
        Object[] values = map.getValues();
        int size = map.size();

        System.out.println("map.get(Number 2): " + number);
        System.out.println("Keys:" + Arrays.toString(keys));
        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Current size: " + size);
        map.removeAll();
        System.out.println("Deleted size: " + map.size());
    }
}
