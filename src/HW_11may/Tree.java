package HW_11may;

import java.util.*;

/**
 * Created by Timbaev on 22.05.2017.
 * Free tree
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public void add(T parent, T children) {
        if (parent == null) {
            if (root == null) root = new Node<>(children);
            else System.out.println("Oups..root already added");
        } else {
            if (root == null) {
                System.out.println("You should add parent!");
                return;
            }
            if (root.getData().equals(parent)) {
                root.addChildren(new Node<>(children));
            } else {
                if (findParent(root.getChildrens(), parent, children)) System.out.println("Added successfully!");
                else System.out.println("Oups..parent not found");
            }
        }
    }

    private boolean findParent(List<Node<T>> list, T parent, T children) {
        for (int i = 0; i < list.size(); i++) {
            Node<T> node = list.get(i);
            if (node.getChildrens().size() != 0) {
                if (findParent(node.getChildrens(), parent, children)) return true;
            }
            if (node.getData().equals(parent)) {
                node.addChildren(new Node<T>(children));
                return true;
            }
        }
        return false;
    }

    public void bypassWidth() {
        Deque<Node<T>> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        while (nodeQueue.peek() != null) {
            Node<T> node = nodeQueue.pop();
            System.out.println(node);
            if (node.hasChildren()) {
                for (int i = 0; i < node.getChildrens().size(); i++) {
                    nodeQueue.add(node.getChildrens().get(i));
                }
            }
        }
    }

    public void circumvention(Node<T> parent) {
        System.out.println(parent);
        List<Node<T>> nodeList = parent.getChildrens();
        if (nodeList.size() != 0) {
            for (int i = 0; i < nodeList.size(); i++) {
                circumvention(nodeList.get(i));
            }
        }
    }

    public Node<T> getRoot() {
        return root;
    }
}
