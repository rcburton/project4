import student.TestCase;

/**
 * The class containing the SkipListTest.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class SkipListTest extends TestCase {

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing to set up
    }


    /**
     * Tests the initialization
     */
    public void testInit() {
        SkipList sL = new SkipList();
        assertNotNull(sL);
        assertEquals(sL.getSize(), 0);
        assertEquals(sL.getLevel(), -1);

    }


    /**
     * Tests the insert() function
     */
    public void testInsert() {
        SkipList sL = new SkipList();
        // Sequence 1, 2, 0
        sL.getRan().setSeed(0xCAFEBEEF);
        sL.insert(1, "one");
        sL.insert(2, "two");
        sL.insert(3, "three");

        assertEquals(sL.getLevel(), 2);
        assertEquals(sL.getSize(), 3);
        assertEquals(sL.getHead().getForward()[0].getKey(), 1);
        assertEquals(sL.getHead().getForward()[0].getForward()[0].getKey(), 2);
        assertEquals(sL.getHead().getForward()[0].getForward()[0]
            .getForward()[0].getKey(), 3);
        assertEquals(sL.getHead().getForward()[1].getKey(), 1);
        assertEquals(sL.getHead().getForward()[1].getForward()[1].getKey(), 2);
        assertEquals(sL.getHead().getForward()[2].getKey(), 2);

    }


    /**
     * Tests the find() function
     */
    public void testFind() {
        SkipList sL = new SkipList();
        // Sequence 1, 2, 0
        sL.getRan().setSeed(0xCAFEBEEF);
        sL.insert(1, "one");
        sL.insert(2, "two");
        sL.insert(3, "three");
        Object temp = sL.find(1);
        Object temp2 = sL.find(9);

        assertEquals(temp, "one");
        assertEquals(temp2, "not_found");

    }


    /**
     * Tests the delete() function
     */
    public void testDelete() {
        SkipList sL = new SkipList();
        // Sequence 1, 2, 0
        sL.getRan().setSeed(0xCAFEBEEF);
        sL.insert(1, "one");
        sL.insert(2, "two");
        sL.insert(3, "three");
        sL.delete(2);

        assertEquals(sL.getHead().getForward()[0].getForward()[0].getKey(), 3);
        assertNull(sL.getHead().getForward()[1].getForward()[1]);
        assertNull(sL.getHead().getForward()[2]);

    }

}
