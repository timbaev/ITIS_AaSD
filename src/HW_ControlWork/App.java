package HW_ControlWork;

/**
 * Created by Timbaev on 22.05.2017.
 */
public class App {

    public static void main(String[] args) {
        Treap treap = new Treap(50, 100);
        treap.insert(55);
        System.out.println(treap.getRight().getX());
        treap.insert(45);
        treap.insert(2);
    }
}
