import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HANStackATest {
    protected HANStackA<Integer> stackA;

    @BeforeEach
    public void Setup() {
        stackA = new HANStackA<Integer>();
    }

    @Test
    public void TestPush() {
        stackA.push(10);
        assertEquals(stackA.top(), 10);
    }

    @Test
    public void TestTop() {
        stackA.push(10);
        stackA.push(20);
        assertEquals(stackA.top(), 20);
    }

    @Test
    public void TestPop() {
        stackA.push(10);
        stackA.pop();
        assertEquals(stackA.top(), null);
    }

    @Test
    public void TestGetSize() {
        stackA.push(10);
        stackA.push(20);
        stackA.push(30);
        assertEquals(stackA.getSize(), 3);
    }
}
