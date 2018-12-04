import student.TestCase;

/**
 * Test class for the Box class
 * 
 * @author Ryan
 * @version 2018-12-03
 *
 */
public class BoxTest extends TestCase {
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
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        assertNotNull(b);
    }
    
    /**
     * 
     */
    public void testSplit() {
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        Box[] bA1 = b.split(1);
        Box[] bA2 = b.split(2);
        Box[] bA3 = b.split(3);
        
        assertEquals(bA1[0].getxMax(), 1024);
        assertEquals(bA1[0].getxMin(), 512);
        assertEquals(bA1[0].getyMax(), 1024);
        assertEquals(bA1[0].getyMin(), 0);
        assertEquals(bA1[0].getzMax(), 1024);
        assertEquals(bA1[0].getzMin(), 0);
        
        assertEquals(bA1[1].getxMax(), 512);
        assertEquals(bA1[1].getxMin(), 0);
        assertEquals(bA1[1].getyMax(), 1024);
        assertEquals(bA1[1].getyMin(), 0);
        assertEquals(bA1[1].getzMax(), 1024);
        assertEquals(bA1[1].getzMin(), 0);
        
        assertEquals(bA2[0].getxMax(), 1024);
        assertEquals(bA2[0].getxMin(), 0);
        assertEquals(bA2[0].getyMax(), 1024);
        assertEquals(bA2[0].getyMin(), 512);
        assertEquals(bA2[0].getzMax(), 1024);
        assertEquals(bA2[0].getzMin(), 0);
        
        assertEquals(bA2[1].getxMax(), 1024);
        assertEquals(bA2[1].getxMin(), 0);
        assertEquals(bA2[1].getyMax(), 512);
        assertEquals(bA2[1].getyMin(), 0);
        assertEquals(bA2[1].getzMax(), 1024);
        assertEquals(bA2[1].getzMin(), 0);
        
        assertEquals(bA3[0].getxMax(), 1024);
        assertEquals(bA3[0].getxMin(), 0);
        assertEquals(bA3[0].getyMax(), 1024);
        assertEquals(bA3[0].getyMin(), 0);
        assertEquals(bA3[0].getzMax(), 1024);
        assertEquals(bA3[0].getzMin(), 512);
        
        assertEquals(bA3[1].getxMax(), 1024);
        assertEquals(bA3[1].getxMin(), 0);
        assertEquals(bA3[1].getyMax(), 1024);
        assertEquals(bA3[1].getyMin(), 0);
        assertEquals(bA3[1].getzMax(), 512);
        assertEquals(bA3[1].getzMin(), 0);
              
    }
    
}
