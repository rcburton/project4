import student.TestCase;

/**
 * The class containing the SkipListTest.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class SkipNodeTest extends TestCase {

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
        SkipNode sN = new SkipNode(1, "one", 1);
        assertNotNull(sN);
        assertEquals(sN.getRec().getKey(), 1);
        assertEquals(sN.getRec().getValue(), "one");
        assertEquals(sN.getLevel(), 1);
        assertEquals(sN.getForward().length, 2);
    }

}
