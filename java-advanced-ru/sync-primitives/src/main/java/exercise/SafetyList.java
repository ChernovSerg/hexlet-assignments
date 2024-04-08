package exercise;

import java.util.Arrays;

class SafetyList {
    private int size = 0;
    private int capacity;
    private int[] data;

    public SafetyList() {
        this.capacity = 2;
        data = new int[capacity];
    }

    public synchronized void add(int element) {
        ensureCapacity(size + 1);
        data[size] = element;
        size = size + 1;
    }

    public int get(int k) {
        return data[k];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void ensureCapacity(int size) {
        if (size <= capacity) {
            return;
        }
        capacity = capacity * 3 / 2 + 1;
        int[] newData = new int[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
