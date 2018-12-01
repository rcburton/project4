import student.TestCase;

public class VarLeafNodeTest extends TestCase{
    /**
     * Function to set up testing environment
     *
     */
    public void setUp() {
        // Nothing to set up
    }
    
    /**
     * Function to test the initialization
     *
     */
    public void testInit() {
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        VarLeafNode vln = new VarLeafNode(b);
        assertNotNull(vln);   
    }
    
    /**
     * Tests the doesIntersect() function
     */
    public void testDoesIntersect() {
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        VarLeafNode vln = new VarLeafNode(b);
        
        String[] balloon = { "add", "balloon", "ba1", "10", "20", "30", "5",
            "10", "15", "hot_air", "40" };
        String[] airplane = { "add", "airplane", "p1", "14", "29", "44", "5",
            "10", "15", "Southwest", "1234", "2" };
        String[] airplane2 = { "add", "airplane", "p2", "18", "38", "58", "5",
            "10", "15", "Southwest", "1234", "2" };
        
        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        Item airplaneItem2 = new Item(airplane2);
        
        assertTrue(vln.doesIntersect(balloonItem, airplaneItem));
        assertTrue(vln.doesIntersect(airplaneItem2, airplaneItem));
        assertFalse(vln.doesIntersect(airplaneItem2, balloonItem));
        
    }

}
