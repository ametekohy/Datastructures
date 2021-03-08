import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HANLinkedListATest {
    protected HANLinkedListA<Integer> linkedListA;

    @BeforeEach
    public void Setup() {
        linkedListA = new HANLinkedListA<Integer>();
    }

    @Test
    public void TestAddFirstValue() {
        linkedListA.addFirst(10);

        assertEquals(linkedListA.get(0).getValue(), 10);
    }

    @Test
    public void TestOverrideHeader() {
        linkedListA.addFirst(10);
        linkedListA.addFirst(20);

        assertEquals(linkedListA.get(0).getValue(), 20);
        assertEquals(linkedListA.get(0).getNext().getValue(), 10);
    }

    @Test
    public void TestGetSize() {
        linkedListA.addFirst(10);
        linkedListA.addFirst(20);

        assertEquals(linkedListA.getSize(), 2);
    }

    @Test
    public void TestInsert() {
        linkedListA.insert(0,10);
        linkedListA.insert(0,20);

        assertEquals(linkedListA.get(0).getValue(), 20);
        assertEquals(linkedListA.get(1).getValue(), 10);
    }

    @Test
    public void TestInsert1() {
        linkedListA.insert(0,5);
        linkedListA.insert(1,10);
        linkedListA.insert(1,20);

        assertEquals(linkedListA.get(1).getValue(), 20);
        assertEquals(linkedListA.get(2).getValue(), 10);
    }

    @Test
    public void TestRemoveFirst() {
        linkedListA.addFirst(10);
        linkedListA.addFirst(20);
        linkedListA.removeFirst();
        assertEquals(linkedListA.get(0).getValue(), 10);
    }

    @Test
    public void TestRemoveFirstNoNext() {
        linkedListA.addFirst(10);
        linkedListA.removeFirst();
        assertEquals(linkedListA.get(0).getValue(), null);
    }

    @Test
    public void TestDelete() {
        linkedListA.addFirst(10);
        linkedListA.addFirst(20);
        linkedListA.delete(0);
        assertEquals(linkedListA.get(0).getValue(), 10);
    }

    @Test
    public void TestToString() {
        linkedListA.addFirst(10);
        linkedListA.addFirst(20);

        assertEquals(linkedListA.toString(), "[20,10]");
    }
}
