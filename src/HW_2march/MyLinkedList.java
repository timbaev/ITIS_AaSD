package HW_2march;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Timbaev on 02.03.2017.
 * Linked list
 */
public class MyLinkedList<T> extends AbstractCollection<T> {

    private Entry<T> head;

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
            return true;
        }
    }

    public void addAfter(T object, T afterObject) {
        Entry<T> objectEnrty = head;
        while (objectEnrty != null) {
            if (objectEnrty.data.equals(afterObject)) {
                if (objectEnrty.next != null) {
                    Entry<T> tempNext = objectEnrty.next;
                    objectEnrty.next = new Entry<>(object);
                    objectEnrty.next.next = tempNext;
                    break;
                } else {
                    objectEnrty.next = new Entry<>(object);
                    break;
                }
            }
            if (objectEnrty.next != null) {
                objectEnrty = objectEnrty.next;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public boolean remove(Object obj) {
        T object = (T) obj;
        Entry<T> objectEntry = head;
        Entry<T> previousEntry = null;
        while (objectEntry != null) {
            if (objectEntry.data.equals(object)) {
                if (previousEntry != null) {
                    if (objectEntry.next != null) {
                        previousEntry.next = objectEntry.next;
                        return true;
                    } else {
                        previousEntry.next = null;
                        return true;
                    }
                } else {
                    head = objectEntry.next;
                    return true;
                }
            }
            if (objectEntry.next != null) {
                previousEntry = objectEntry;
                objectEntry = objectEntry.next;
            } else {
                return false;
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
        Entry<T> objectEntry = head;
        while (objectEntry != null) {
            if (objectEntry.data.equals(object)) {
                return true;
            }
            if (objectEntry.next != null) {
                objectEntry = objectEntry.next;
            } else {
                return false;
            }
        }
        return false;
    }

    public void merge(MyLinkedList<T> linkedList) {
        Entry<T> lastEntry = head;
        while (lastEntry.next != null) {
            lastEntry = lastEntry.next;
        }
        lastEntry.next = linkedList.head;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyLinkedListIterator implements Iterator<T> {
        private Entry<T> currentEntry;

        public MyLinkedListIterator() {
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
        private T data;

        public Entry(T data) {
            this.data = data;
        }
    }
}