
/**
 *  author: Arthur Metekohy
 *  semester: APP 2020
 */
public class ArrayListA<T> {
    private T[] list;
    private int currentSize;
    private int currentPosition;

    public ArrayListA(int size) {
        this.list = (T[]) new Object[size];
        this.currentSize = size;
        this.currentPosition = 0;
    }


    public void add(T value) {
        if(this.list.length >= currentSize) {
            this.ArrayIsVol();
        }

        if(this.list[currentPosition] == null) {
            this.list[currentPosition] = value;
            currentPosition++;
        }
    }

    public T get(int index) {
        return this.list[index];
    }

    public void set(int index, T value) {
        this.list[index] = value;
    }

    public int size() {
        return this.list.length;
    }

    public String toString() {
        StringBuilder text = new StringBuilder("[");

        for(int i=0;i<currentSize;i++){
            text.append(this.list[i]).append(",");
        }

        return text.substring(0, text.length() -1) + "]";
    }

    private void ArrayIsVol() {
        if(currentPosition == currentSize) {
            T[] old = this.list;
            this.list = (T[]) new Object[currentSize*2+1];

            for(int i=0; i<currentSize;i++){
                this.list[i] = old[i];
            }

            currentSize = currentSize*2+1;
        }
    }
}
