package HW_16Febrary.map;

/**
 * Created by Timbaev on 16.02.2017.
 * Main Map interface
 */
public interface Map {
    void add(String key, Object value);
    void remove(String key);
    Object get(String key);
    void set(String key, Object value);
    void removeAll();
    String[] getKeyes();
    Object[] getValues();
    int size();
}
