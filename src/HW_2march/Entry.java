package HW_2march;

/**
 * Created by Timbaev on 02.03.2017.
 */
public class Entry<L> {
    private Entry<L> next;
    private L data;

    public Entry(L data) {
        this.data = data;
        next = null;
    }

    public void setNext(Entry<L> nextEntry) {
        if (next == null) {
            next = nextEntry;
        } else {
            next.setNext(nextEntry);
        }
    }

    public Entry<L> getNext() {
        return next;
    }

    public L getData() {
        return data;
    }

    public boolean hasNext() {
        return next != null;
    }
}
