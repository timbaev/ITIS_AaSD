package HW_2march;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Timbaev on 15.03.2017.
 * Doubly Linked List
 */
public class MyDoublyLinkedList<T> extends AbstractCollection<T> {

    private Entry<T> head;
    private Entry<T> tail;

    public boolean add(T object) {
        if (head == null) {
            head = new Entry<>(object);
            return true;
        } else {
            Entry<T> lastEntry = head;
            while (lastEntry.next != null) {
                lastEntry = lastEntry.next;
            }
            lastEntry.next = new Entry<>(object);
            tail = lastEntry.next;
            tail.previous = lastEntry;
            return true;
        }
    }

    public void addAfter(T object, T afterObject) {
        Entry<T> objectEntry = getEntryWithObject(afterObject);
        if (objectEntry != null) {
            Entry<T> insertEntry = new Entry<>(object);
            if (objectEntry.next != null) {
                Entry<T> tempNext = objectEntry.next;
                objectEntry.next = insertEntry;
                insertEntry.next = tempNext;
                tempNext.previous = insertEntry;
            } else {
                tail = insertEntry;
                objectEntry.next = tail;
                tail.previous = objectEntry;
            }
        }
    }

    public boolean remove(Object obj) {
        T object = (T) obj;
        Entry<T> objectEntry = getEntryWithObject(object);
        if (objectEntry != null) {
            if (objectEntry.next != null && objectEntry.previous != null) {
                objectEntry.previous.next = objectEntry.next;
                return true;
            }
            if (objectEntry.equals(head)) {
                head = objectEntry.next;
                head.previous = null;
                return true;
            }
            if (objectEntry.equals(tail)) {
                tail = objectEntry.previous;
                tail.next = null;
                return true;
            }
        }
        return false;
    }

    public T get(int position) {
        Entry<T> currentEntry = head;
        for (int i = 0; i < position; i++) {
            if (currentEntry.next == null) throw new ArrayIndexOutOfBoundsException();
            currentEntry = currentEntry.next;
        }
        return currentEntry.data;
    }

    public boolean has(T object) {
        try {
            getEntryWithObject(object);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void merge(MyDoublyLinkedList<T> linkedList) {
        Entry<T> lastEntry = head;
        while (lastEntry.next != null) {
            lastEntry = lastEntry.next;
        }
        lastEntry.next = linkedList.head;
        linkedList.tail = lastEntry;
    }

    private Entry<T> getEntryWithObject(T object) {
        Entry<T> objectEntry = head;
        while (objectEntry != null) {
            if (objectEntry.data.equals(object)) {
                return objectEntry;
            }
            if (objectEntry.next != null) {
                objectEntry = objectEntry.next;
            } else {
                throw new NoSuchElementException("Element not found");
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyDoublyLinkedListIterator();
    }

    @Override
    public int size() {
        int count = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        return count;
    }

    private class MyDoublyLinkedListIterator implements Iterator<T> {
        private Entry<T> currentEntry;

        public MyDoublyLinkedListIterator() {
            currentEntry = head;
        }

        @Override
        public boolean hasNext() {
            return currentEntry != null;
        }

        @Override
        public T next() {
            Entry<T> returnEntry = currentEntry;
            currentEntry = currentEntry.next;
            return returnEntry.data;
        }
    }

    private class Entry<T> {
        private Entry<T> next;
        private Entry<T> previous;
        private T data;

        public Entry(T data) {
            this.data = data;
        }
    }
}
