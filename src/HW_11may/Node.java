package HW_11may;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timbaev on 22.05.2017.
 * Main node
 */
public class Node<T> {

    private T data;
    private List<Node<T>> childrens;

    public Node(T data) {
        this.data = data;
        childrens = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getChildrens() {
        return childrens;
    }

    public void addChildren(Node<T> children) {
        childrens.add(children);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public boolean hasChildren() {
        return childrens.size() != 0;
    }
}
