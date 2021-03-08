public class HANLinkedListA<T> {
    public class ListNode {
        private T value;
        private ListNode next;

        public ListNode(T value) {
            this.value = value;
        }

        public ListNode(T value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setNext(ListNode node) {
            next = node;
        }

        public ListNode getNext() {
            return next;
        }
    }

    private ListNode header;

    public HANLinkedListA(){
        header = new ListNode(null,null);
    }

    public void addFirst(T value) {
        if(isEmpty()) {
            header = new ListNode(value);
        } else {
            ListNode newNextNode = header;
            header = new ListNode(value,newNextNode);
        }
    }

    private boolean isEmpty() {
        if(header.getValue() == null) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        int size = 0;
        ListNode current = header;
        while(current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    public void removeFirst() {
        if(header.getNext() != null) {
            ListNode node = header.getNext();
            header = node;
        } else
            header = new ListNode(null);
    }

    public void insert(int index, T value) {
        if(index >= 1 && value != null) {
            ListNode current = header;

            for(int i=0; i < index-1; i++ ) {
                current = current.getNext();
            }
            if(current != null) {
                current.setNext(new ListNode(value, current.getNext()));
            }
        } else if(index == 0) {
            addFirst(value);
        }
    }

    public void delete(int index) {
        if(index >= 1 ) {
            ListNode current = header;

            for(int i=0; i < index; i++ ) {
                current = current.getNext();
            }

            ListNode next = current.getNext();

            if(next.getNext() != null) {
                current.setNext(next.getNext());
            }
        } else if(index == 0) {
            removeFirst();
        }
    }

    public ListNode get(int index) {
        if(index >= 0 ) {
            ListNode ref = header;

            for (int i = 0; i < index; i++) {
                ref = ref.getNext();
            }
            if(ref != null) {
                return ref;
            } else
                return null;
        } else
            return null;
    }

    public String toString() {
        StringBuilder text = new StringBuilder("[");

        ListNode current = header;
        while(current != null) {
            text.append(current.getValue()).append(",");
            current = current.getNext();
        }

        return text.substring(0, text.length() -1) + "]";
    }
}
