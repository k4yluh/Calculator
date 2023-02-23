
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class linkedListTests {

    @Test
    public void testAdd()
    {
        linkedList list = new linkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        String res = list.printList();
        assertEquals(res, "1230");
    }

    @Test
    public void testRemove(){
        linkedList list = new linkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.pop();  // removes top element
        String res = list.printList();
        assertEquals(res, "230");

    }

    @Test
    public void testIndex(){
        linkedList list = new linkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        // 1 2 3 0
        int i0 = list.getVal(0);
        int i1 = list.getVal(1);
        int i2 = list.getVal(2);
        int i3 = list.getVal(3);
        assertEquals(i0, 1);
        assertEquals(i1, 2);
        assertEquals(i2, 3);
        assertEquals(i3, 0);
    }

    @Test
    public void testAll(){
        linkedList list = new linkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        // 1,2,3,0,
        list.pop();
        // 2,3,0,
        list.add(9);
        // 2,3,0,9,
        list.pop();
        // 3,0,9,
        int i0 = list.getVal(0);
        int i1 = list.getVal(1);
        int i2 = list.getVal(2);
        assertEquals(i0, 3);
        assertEquals(i1, 0);
        assertEquals(i2, 9);
        list.printList();

    }
    @Test
    public void testSize(){
        linkedList list = new linkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        assertEquals(list.getSize(), 4);
        list.pop();
        list.pop();
        assertEquals(list.getSize(), 2);
    }


}
