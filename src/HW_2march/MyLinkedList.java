package HW_2march;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Created by Timbaev on 02.03.2017.
 * Linked list
 */
public class MyLinkedList<T> extends AbstractCollection<T> {

    private Entry<T> head;

    public boolean add(T data) {
        if (head == null) {
            head = new Entry<>(data);
            return true;
        } else {
            head.setNext(new Entry<>(data));
            return true;
        }
    }

    public boolean addAfter(T data, T afterData) {
        Entry<T> currentEntry = head;
        while (currentEntry.hasNext() || currentEntry == head) {
            if (currentEntry.getData().equals(afterData)) {
                Entry<T> tempEntry = currentEntry.getNext();
                currentEntry.setNext(new Entry<>(data));
                currentEntry.getNext().setNext(tempEntry);
                return true;
            }
            currentEntry = currentEntry.getNext();
        }
        return false;
    }

    public boolean remove(Object data) {
        T tData = (T) data;
        Entry<T> currentEntry = head;
        Entry<T> previousEntry = null;
        while (currentEntry.hasNext() || currentEntry == head) {
            if (currentEntry.getData().equals(tData)) {
                if (currentEntry == head) {
                    head = currentEntry.getNext();
                } else {
                    assert previousEntry != null;
                    previousEntry.setNext(currentEntry.getNext());
                }
                return true;
            }
            previousEntry = currentEntry;
            currentEntry = currentEntry.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public int size() {
        int count = 0;
        while (head.hasNext()) {
            count++;
        }
        return count;
    }

    public T get(int position) {
        Entry<T> currentEntry = head;
        for (int i = 0; i < position; i++) {
            if (!currentEntry.hasNext()) throw new IndexOutOfBoundsException();
            currentEntry = currentEntry.getNext();
        }
        return currentEntry.getData();
    }

    public boolean has(T data) {
        Entry<T> currentEntry = head;
        while (currentEntry.hasNext() || currentEntry == head) {
            if (currentEntry.getData().equals(data)) {
                return true;
            }
            currentEntry = currentEntry.getNext();
        }
        return false;
    }

    public void merge(MyLinkedList<T> linkedList) {
        Entry<T> currentEntry = head;
        while (currentEntry.hasNext()) {
            currentEntry = currentEntry.getNext();
        }
        currentEntry.setNext(linkedList.getHead());
    }

    private Entry<T> getHead() {
        return head;
    }

    private class LinkedListIterator implements Iterator<T> {
        Entry<T> currentEntry;

        LinkedListIterator() {
            currentEntry = head;
        }

        @Override
        public boolean hasNext() {
            return currentEntry.hasNext();
        }

        @Override
        public T next() {
            T data = currentEntry.getData();
            currentEntry = currentEntry.getNext();
            return data;
        }
    }
}