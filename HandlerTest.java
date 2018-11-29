import student.TestCase;

/**
 * The class containing the HandlerTest.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class HandlerTest extends TestCase {
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
        Handler handler = new Handler(sL);

        assertNotNull(handler);

    }


    /**
     * Tests the handleCommands() function
     */
    public void testHandleCommands() {
        SkipList sL = new SkipList();
        Handler handler = new Handler(sL);
        String[] balloon = { "add", "balloon", "ba1", "10", "20", "30", "5",
            "10", "15", "hot_air", "40" };
        String[] airplane = { "add", "airplane", "p1", "40", "50", "60", "15",
            "10", "5", "Southwest", "1234", "2" };
        String[] negWidth = { "add", "balloon", "ba2", "10", "20", "30", "-5",
            "-10", "-15", "hot_air", "40" };
        String[] negOrigin = { "add", "balloon", "ba3", "-10", "-20", "-30",
            "5", "10", "15", "hot_air", "40" };
        String[] outBounds = { "add", "balloon", "ba4", "2010", "2020", "2030",
            "5", "10", "15", "hot_air", "40" };
        String[] delete = { "delete", "del" };
        String[] print = { "print", "skiplist" };
        String[] rangeprint = { "rangeprint", "start", "end" };
        String[] error = { "kfsmfkwefmwkr", "start", "end" };
        handler.handleCommands(balloon);
        handler.handleCommands(balloon);
        handler.handleCommands(airplane);
        handler.handleCommands(negWidth);
        handler.handleCommands(negOrigin);
        handler.handleCommands(outBounds);
        handler.handleCommands(delete);
        handler.handleCommands(print);
        handler.handleCommands(rangeprint);
        handler.handleCommands(error);

        assertEquals(handler.getSkipList().getSize(), 2);
    }


    /**
     * Tests the insert() function
     */
    public void testInsert() {
        Parser p = new Parser();
        SkipList sL = new SkipList();
        Handler handler = new Handler(sL);
        String testBalloon = "add balloon ba1 10 20 30 5 10 15 hot_air 40";
        String testAirplane =
            "add airplane p1 40 50 60 15 10 5 Southwest 1234 2";
        String testNegWidth = "add balloon ba1 10 20 30 -5 -10 -15 hot_air 40";
        String testNegOrigin = "add balloon ba1 -10 -20 -30 5 10 15 hot_air 40";
        String testOutBounds =
            "add balloon ba1 2010 2020 2030 5 10 15 hot_air 40";
        String[] balloon = p.parseLine(testBalloon);
        String[] airplane = p.parseLine(testAirplane);
        String[] negWidth = p.parseLine(testNegWidth);
        String[] negOrigin = p.parseLine(testNegOrigin);
        String[] outBounds = p.parseLine(testOutBounds);
        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        Item negWidthItem = new Item(negWidth);
        Item negOriginItem = new Item(negOrigin);
        Item outBoundsItem = new Item(outBounds);
        handler.insert(balloonItem);
        handler.insert(balloonItem);
        handler.insert(airplaneItem);
        handler.insert(negWidthItem);
        handler.insert(negOriginItem);
        handler.insert(outBoundsItem);

        assertEquals(handler.getSkipList().getSize(), 2);

    }


    /**
     * Tests the delete() function
     */
    public void testDelete() {
        Parser p = new Parser();
        SkipList sL = new SkipList();
        Handler handler = new Handler(sL);
        String testBalloon = "add balloon ba1 10 20 30 5 10 15 hot_air 40";
        String testAirplane =
            "add airplane p1 40 50 60 15 10 5 Southwest 1234 2";
        String[] balloon = p.parseLine(testBalloon);
        String[] airplane = p.parseLine(testAirplane);
        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        handler.insert(balloonItem);
        handler.insert(airplaneItem);
        handler.delete(balloonItem.getName());
        handler.delete(balloonItem.getName());

        assertEquals(handler.getSkipList().getSize(), 1);
    }


    /**
     * Tests the print() function
     */
    public void testPrint() {
        String[] print1 = { "print", "skiplist" };
        String[] print2 = { "print", "object", "ba1" };
        String[] print3 = { "print", "object", "invalid1" };
        String[] print4 = { "print", "objectfwfwfwe", "invalid1" };
        Parser p = new Parser();
        SkipList sL = new SkipList();
        // Sequence 1, 2, 0
        sL.getRan().setSeed(0xCAFEBEEF);
        Handler handler = new Handler(sL);
        String testBalloon = "add balloon ba1 10 20 30 5 10 15 hot_air 40";
        String testAirplane =
            "add airplane p1 40 50 60 15 10 5 Southwest 1234 2";
        String testRocket = "add rocket r1 70 80 90 5 5 15 50 45.5";
        String[] balloon = p.parseLine(testBalloon);
        String[] airplane = p.parseLine(testAirplane);
        String[] rocket = p.parseLine(testRocket);
        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        Item rocketItem = new Item(rocket);
        handler.insert(balloonItem);
        handler.insert(airplaneItem);
        handler.insert(rocketItem);
        handler.print(print1);
        handler.print(print2);
        handler.print(print3);
        handler.print(print4);

        assertEquals(handler.getSkipList().getSize(), 3);

    }


    /**
     * Tests the rangeprint() function
     */
    public void testRangeprint() {
        String[] print1 = { "rangeprint", "ba1", "r1" };
        String[] print2 = { "rangeprint", "r1", "ba1" };
        Parser p = new Parser();
        SkipList sL = new SkipList();
        // Sequence 1, 2, 0
        sL.getRan().setSeed(0xCAFEBEEF);
        Handler handler = new Handler(sL);
        String testBalloon = "add balloon ba1 10 20 30 5 10 15 hot_air 40";
        String testAirplane =
            "add airplane p1 40 50 60 15 10 5 Southwest 1234 2";
        String testRocket = "add rocket r1 70 80 90 5 5 15 50 45.5";
        String[] balloon = p.parseLine(testBalloon);
        String[] airplane = p.parseLine(testAirplane);
        String[] rocket = p.parseLine(testRocket);
        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        Item rocketItem = new Item(rocket);
        handler.insert(balloonItem);
        handler.insert(airplaneItem);
        handler.insert(rocketItem);
        handler.rangeprint(print1);
        handler.rangeprint(print2);

        assertEquals(handler.getSkipList().getSize(), 3);

    }
}
