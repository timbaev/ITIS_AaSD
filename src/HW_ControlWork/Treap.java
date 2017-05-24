package HW_ControlWork;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Timbaev on 22.05.2017.
 *
 */
public class Treap {

    private int x;
    private int y;

    private Treap left;
    private Treap right;

    public Treap getLeft() {
        return left;
    }

    public Treap getRight() {
        return right;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private Treap(int x, int y, Treap left, Treap right) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }

    public Treap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Treap merge(Treap L, Treap R) {
        if (L == null) return R;
        if (R == null) return L;

        if (L.y > R.y) {
            right = merge(L.right, R);
            return new Treap(L.x, L.y, L.left, right);
        } else {
            left = merge(L, R.left);
            return new Treap(R.x, R.y, left, R.right);
        }
    }

    public Treap[] split(int x, Treap L, Treap R) {
        Treap newTree = null;

        if (this.x <= x) {
            if (right == null) R = null;
            else right.split(x, newTree, R);
            L = new Treap(this.x, y, left, newTree);
        } else {
            if (left == null) L = null;
            else left.split(x, L, newTree);
            R = new Treap(this.x, y, newTree, right);
        }
        return new Treap[] {L, R};
    }

    public void insert(int x) {
        Treap l = null;
        Treap r = null;
        Treap[] splited = split(x, l, r);
        Treap m = new Treap(x, ThreadLocalRandom.current().nextInt(100));
        merge(merge(splited[0], m), splited[1]);
    }

    public Treap remove(int x) {
        Treap l = null;
        Treap r = null;
        Treap m = null;
        Treap[] splied1 = split(x - 1, l, r);
        Treap[] splited2 = r.split(x, m, r);
        return merge(splied1[0], splited2[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Treap treap = (Treap) o;

        if (x != treap.x) return false;
        if (y != treap.y) return false;
        if (!left.equals(treap.left)) return false;
        return right.equals(treap.right);

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + left.hashCode();
        result = 31 * result + right.hashCode();
        return result;
    }
}
