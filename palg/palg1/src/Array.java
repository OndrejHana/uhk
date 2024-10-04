
public class Array {
    private int[] data;
    private int length;
    private int capacity;

    public Array(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
        this.length = 0;
    }

    public Array() {
        this(10);
    }

    public void extend() {
        var temp = this.data;
        this.capacity = this.capacity * 2;
        this.data = new int[this.capacity];
        for (int i = 0; i < temp.length; i++) {
            this.data[i] = temp[i];
        }
        System.arraycopy(temp, 0, this.data, 0, temp.length);
    }

    public void add(int val) {
        if (this.length == this.capacity) {
            this.extend();
        }

        this.data[this.length] = val;
        this.length++;
    }

    public void insert(int index, int val) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.capacity);
        }

        if (this.length == this.capacity) {
            this.extend();
        }

        for (int i = this.length; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.length++;
        this.data[index] = val;
    }

    public int remove(int index) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.capacity);
        }

        var el = this.data[index];
        for (int i = index; i < this.length; i++) {
            this.data[i] = this.data[i + 1];
        }

        return el;
    }

    public int indexOf(int val) {

        for (int i = 0; i < this.length; i++) {
            if (this.data[i] == val) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(int val) {
        for (int i = this.length; i >= 0; i--) {
            if (this.data[i] == val) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        var temp = "len: " + this.length + ", capacity: " + this.capacity + ", elements: ";
        for (int i = 0; i < this.length; i++) {
            temp += this.data[i] + " ";
        }
        return temp;
    }
}
