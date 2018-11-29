import student.TestCase;

/**
 * The class containing the KVPairTest.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class KVPairTest extends TestCase {
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
        KVPair kv1 = new KVPair(1, "one");
        assertNotNull(kv1);
        assertEquals(kv1.getValue(), "one");
        assertEquals(kv1.getKey(), 1);
    }

}
