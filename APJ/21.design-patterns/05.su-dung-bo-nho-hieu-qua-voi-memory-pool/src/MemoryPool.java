import java.util.LinkedList;

public abstract class MemoryPool<T> {
    private final LinkedList<T> freeItems = new LinkedList<>();

    public void freeItem(T item) {
        freeItems.add(item);
    }

    protected abstract T allocate();

    public T getNewItem() {
        if (freeItems.isEmpty()) return allocate();
        return freeItems.removeFirst();
    }
}
