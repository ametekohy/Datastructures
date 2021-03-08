import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListATest {
    protected ArrayListA<Integer> ints;

    @BeforeEach
    public void Setup() {
        this.ints = new ArrayListA<Integer>(5);
    }

    @Test
    public void testAdd() {
        this.ints.add(10);
        Integer test = this.ints.get(0);

        assertEquals(test, 10);
    }

    @Test
    public void testSet() {
        this.ints.add(10);
        this.ints.set(0, 5);

        assertEquals(this.ints.get(0), 5);
    }

    @Test
    public void testArrayNietVol() {
        this.ints.add(1);
        this.ints.add(2);
        this.ints.add(3);
        this.ints.add(4);
        this.ints.add(5);

        assertEquals(this.ints.size(), 5);
    }

    @Test
    public void testArrayVol() {
        this.ints.add(1);
        this.ints.add(2);
        this.ints.add(3);
        this.ints.add(4);
        this.ints.add(5);
        this.ints.add(6);

        assertEquals(this.ints.size(), (5*2)+1);
    }

    @Test
    public void testToString() {
        this.ints.add(1);
        this.ints.add(2);
        this.ints.add(3);
        this.ints.add(4);
        this.ints.add(5);

        assertEquals(this.ints.toString(), "[1,2,3,4,5]");
    }
}
