public class HANStackA<T> {
    private HANLinkedListA<T> linkedList ;

    public HANStackA() {
        this.linkedList = new HANLinkedListA<T>();
    }

    public T pop()
    {
        T tmp = top();
        linkedList.delete(getSize()-1);
        return tmp;
    }

    public T top()
    {
        return (T) linkedList.get(getSize()-1).getValue();
    }

    public HANStackA<T> push(T v)
    {
        if(linkedList.get(0).getValue() == null) {
            linkedList.addFirst(v);
        } else {
            linkedList.insert(this.getSize(), v);
        }
        return this;
    }

    public int getSize()
    {
        return this.linkedList.getSize();
    }
}
