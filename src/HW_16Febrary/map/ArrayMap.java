package HW_16Febrary.map;

import HW_16Febrary.exception.KeyAlreadyExistsException;
import HW_16Febrary.exception.KeyNotFoundException;

import java.util.ArrayList;

/**
 * Created by Timbaev on 16.02.2017.
 * ArrayMap
 */
public class ArrayMap<K, V> implements Map<K, V> {

    private ArrayList<K> keys;
    private ArrayList<V> values;

    public ArrayMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public ArrayMap(int size) {
        keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
    }

    @Override
    public void add(K key, V value) {
        checkKey(key);
        keys.add(key);
        values.add(value);
    }

    @Override
    public void remove(K key) {
        int keyNumber = keys.indexOf(key);
        if (keyNumber != -1) {
            keys.remove(keyNumber);
            values.remove(keyNumber);
        } else {
            throw new KeyNotFoundException("Error..key not found");
        }
    }

    @Override
    public V get(K key) {
        int keyNumber = foundkey(key);
        return values.get(keyNumber);
    }

    @Override
    public void set(K key, V value) {
        int keyNumber = foundkey(key);
        values.set(keyNumber, value);
    }

    @Override
    public void removeAll() {
        keys.clear();
        values.clear();
    }

    @Override
    public K[] getKeyes() {
        return (K[]) keys.toArray(new String[keys.size()]);
    }

    @Override
    public V[] getValues() {
        return (V[]) values.toArray(new Object[values.size()]);
    }

    @Override
    public int size() {
        return keys.size();
    }

    private void checkKey(K key) {
        if (keys.contains(key)) throw new KeyAlreadyExistsException("Error..key already exists");
    }

    private int foundkey(K key) {
        int keyNumber = keys.indexOf(key);
        if (keyNumber == -1) throw new KeyNotFoundException("Error..key not found");
        return keyNumber;
    }
}
