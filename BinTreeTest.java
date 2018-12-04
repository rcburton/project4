import student.TestCase;

/**
 * Test class for the BinTree
 * 
 * @author Ryan and Sayan
 * @version 12/3/18
 *
 */
public class BinTreeTest extends TestCase {
    
    /**
     * Function to set up testing environment
     *
     */
    public void setUp() {
        // Nothing to set up
    }


    /**
     * Tests the initialization
     *
     */
    public void testInit() {
        BinTree bT = new BinTree();
        assertNotNull(bT);
    }
    
    /**
     * Tests the level() function
     */
    public void testLevel() {
        Box b1 = new Box(1024, 0, 1024, 0, 1024, 0);
        BinTree bT = new BinTree();
        
        assertNotNull(b1);
        assertNotNull(bT);
        
    }

}
