package HW_9Febrary;

public class Stack implements Sequence {

    private Object[] objects;

    public Stack() {
        objects = new Object[0];
    }

    @Override
    public void add(Object obj) {
        Object[] newObjects = new Object[objects.length + 1];
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length - 1] = obj;
        objects = newObjects;
    }

    @Override
    public Object pop() {
        if (objects.length != 0) {
            Object obj = objects[objects.length - 1];
            Object[] newOBjects = new Object[objects.length - 1];
            System.arraycopy(objects, 0, newOBjects, 0, newOBjects.length);
            objects = newOBjects;
            return obj;
        } else {
            return null;
        }
    }

    @Override
    public Object peek() {
        if (objects.length != 0) {
            return objects[objects.length - 1];
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return objects.length;
    }

}
