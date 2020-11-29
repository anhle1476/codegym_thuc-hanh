import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T> {
    private final long EXPIRATION_TIME;
    private final Hashtable<T, Long> locked;
    private final Hashtable<T, Long> unlocked;
    private long now;

    public ObjectPool() {
        EXPIRATION_TIME = 30000;
        locked = new Hashtable<>();
        unlocked = new Hashtable<>();
    }

    protected abstract T create();

    public abstract boolean validate(T o);

    public abstract void expire(T o);

    public synchronized T checkOut() {
        now = System.currentTimeMillis();
        T t = null;
        if (isObjectAvailableInPool()) {
            t = getAvailableObject();
        }
        return (t != null) ? t : getNewObject();
    }

    private boolean isObjectAvailableInPool() {
        return unlocked.size() > 0;
    }

    private T getAvailableObject() {
        Enumeration<T> e = unlocked.keys();
        while (e.hasMoreElements()) {
            T currentObject = e.nextElement();
            Long objTime = unlocked.remove(currentObject);
            currentObject = getValidObject(currentObject, objTime);
            if (currentObject != null) return currentObject;
        }
        return null;
    }

    private T getValidObject(T object, Long objTime) {
        boolean isExpiredOrInvalid = (now - objTime) > EXPIRATION_TIME || !validate(object);
        if (isExpiredOrInvalid) {
            expire(object);
            return null;
        } else {
            locked.put(object, now);
            return (object);
        }
    }

    private T getNewObject() {
        T t = create();
        locked.put(t, now);
        return t;
    }

    public synchronized void checkIn(T t) {
        locked.remove(t);
        unlocked.put(t, System.currentTimeMillis());
    }
}
