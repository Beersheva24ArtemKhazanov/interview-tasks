package telran.interview;

import java.util.HashMap;

public class MyArray<T> {
    private int size;
    private HashMap<Integer, T> map;
    private T value;

    public void setAll(T value) {
        this.value = value;
        this.map = new HashMap<>();

    }

    public void set(int index, T value) {
        checkIndex(index);
        this.map.put(index, value);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        checkIndex(index);
        return map.getOrDefault(index, value);

    }

    public MyArray(int size) {
        this.size = size;
        setAll(null);
    }
}
