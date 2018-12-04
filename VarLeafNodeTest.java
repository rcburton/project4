import student.TestCase;

/**
 * @author Ryan
 * @version 2018-12-03
 *
 */
public class VarLeafNodeTest extends TestCase {
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
        String[] balloon2 = { "add", "balloon", "ba1", "1000", "120", "130",
            "5", "10", "15", "hot_air", "40" };

        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        Item airplaneItem2 = new Item(airplane2);
        Item balloonItem2 = new Item(balloon2);

        assertTrue(vln.doesIntersect(balloonItem, airplaneItem));
        assertTrue(vln.doesIntersect(airplaneItem2, airplaneItem));
        assertFalse(vln.doesIntersect(airplaneItem2, balloonItem));
        assertFalse(vln.doesIntersect(balloonItem2, balloonItem));
        assertFalse(vln.doesIntersect(balloonItem2, airplaneItem2));
        assertFalse(vln.doesIntersect(balloonItem2, airplaneItem2));

    }


    /**
     * Tests the insert() function
     */
    public void testInsert() {
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        VarLeafNode vln = new VarLeafNode(b);
        VarIntlNode vin = new VarIntlNode(VarFlyWeight.getInstance(),
            VarFlyWeight.getInstance());

        String[] item1 = { "add", "balloon", "ba1", "10", "10", "10", "5", "5",
            "5", "hot_air", "40" };
        String[] item2 = { "add", "balloon", "ba2", "20", "20", "20", "5", "5",
            "5", "hot_air", "40" };
        String[] item3 = { "add", "balloon", "ba3", "30", "30", "30", "5", "5",
            "5", "hot_air", "40" };
        String[] item4 = { "add", "balloon", "ba4", "40", "40", "40", "5", "5",
            "5", "hot_air", "40" };

        Item i1 = new Item(item1);
        Item i2 = new Item(item2);
        Item i3 = new Item(item3);
        Item i4 = new Item(item4);

        vin = vln.insert(i1, (VarBinNode)vln);
        vin = vln.insert(i2, (VarBinNode)vln);
        vin = vln.insert(i3, (VarBinNode)vln);

        assertNull(vin);
        assertEquals(vln.getSize(), 3);

        vin = vln.insert(i4, (VarBinNode)vln);

        assertNotNull(vin);
        assertEquals(vln.getSize(), 3);

    }

}
