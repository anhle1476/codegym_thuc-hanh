import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] objects = new Object[DEFAULT_CAPACITY];

    public MyList() {}

    public MyList(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public int size() {return size;}

    public E get(int index) {
        return (E) objects[index];
    }

    public boolean contains(E e) {return indexOf(e) != -1;}

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(objects[i])) return i;
        }
        return -1;
    }

    public boolean add(E element) {
        if (isNull(element)) return false;
        add(size, element);
        return true;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (isNull(element)) return;
        if(isIndexOutOfRange(index, size)) throw new IndexOutOfBoundsException();
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            objects[i] = objects[i - 1];
        }
        objects[index] = element;
        size++;
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    public void ensureCapacity(int minCapacity) {
        int minSize = Math.max(minCapacity, size);
        if (minSize > objects.length) growCapacity(minSize * 2);
    }

    private void growCapacity(int newCapacity) {
        Object[] newObjects = new Object[newCapacity];
        System.arraycopy(objects, 0, newObjects, 0, size);
        objects = newObjects;
    }

    public E remove(int index) {
        if (isIndexOutOfRange(index, size - 1)){ return null;}
        Object holder = objects[index];
        for (int i = index; i < size - 1; i++) {
            objects[i] = objects[i + 1];
        }
        objects[size - 1] = null;
        size--;
        return (E) holder;
    }
    private boolean isIndexOutOfRange(int index, int limit) {
        return index < 0 && index > limit;
    }

    public MyList<E> clone() {
        return new MyList<>((E[]) objects);
    }

    @Override
    public String toString() {
        return "MyList=" + Arrays.toString(objects);
    }
}
