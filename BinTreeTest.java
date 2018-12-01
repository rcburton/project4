import student.TestCase;

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
        Box b1 = new Box(1024, 0, 1024, 0, 1024, 0);
        BinTree bT = new BinTree();
        assertNotNull(bT);
    }
    
    public void testLevel() {
        Box b1 = new Box(1024, 0, 1024, 0, 1024, 0);
        BinTree bT = new BinTree();
        
    }

}
