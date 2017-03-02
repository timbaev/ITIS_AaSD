package HW_16Febrary.map;

/**
 * Created by Timbaev on 16.02.2017.
 * Main Map interface
 */
public interface Map<K, V> {
    void add(K key, V value);
    void remove(K key);
    V get(K key);
    void set(K key, V value);
    void removeAll();
    K[] getKeyes();
    V[] getValues();
    int size();
}
