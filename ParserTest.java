import student.TestCase;

public class ParserTest extends TestCase {
    public void setUp() {
        // Nothing to set up
    }


    public void testParseLine() {
        Parser p = new Parser();

        String testBalloon = "add balloon ba1 10 20 30 5 10 15 hot_air 40";
        String testAirplane =
            "add airplane p1 40 50 60 15 10 5 Southwest 1234 2";
        String testRocket = "add rocket r1 70 80 90 5 5 15 50 45.5";
        String testDrone = "add drone d1 100 110 120 5 5 5 Amazon 4";
        String testBird = "add bird bi1 130 140 150 10 10 10 Dinosaur 10";
        String testDelete = "delete del1";
        String testPrintSL = "print skiplist";
        String testPrintBT = "print bintree";
        String testPrintObj = "print object obj1";
        String testRangeprint = "rangeprint 1 2";
        String testCollisions = "collisions";
        String testIntersect = "intersect 1 2 3 4 5 6";

        String[] balloon = p.parseLine(testBalloon);
        String[] airplane = p.parseLine(testAirplane);
        String[] rocket = p.parseLine(testRocket);
        String[] drone = p.parseLine(testDrone);
        String[] bird = p.parseLine(testBird);
        String[] delete = p.parseLine(testDelete);
        String[] printSL = p.parseLine(testPrintSL);
        String[] printBT = p.parseLine(testPrintBT);
        String[] printObj = p.parseLine(testPrintObj);
        String[] rangeprint = p.parseLine(testRangeprint);
        String[] collisions = p.parseLine(testCollisions);
        String[] intersect = p.parseLine(testIntersect);

        assertEquals("add", balloon[0]);
        assertEquals("balloon", balloon[1]);
        assertEquals("ba1", balloon[2]);
        assertEquals("10", balloon[3]);
        assertEquals("20", balloon[4]);
        assertEquals("30", balloon[5]);
        assertEquals("5", balloon[6]);
        assertEquals("10", balloon[7]);
        assertEquals("15", balloon[8]);
        assertEquals("hot_air", balloon[9]);
        assertEquals("40", balloon[10]);

        assertEquals("add", airplane[0]);
        assertEquals("airplane", airplane[1]);
        assertEquals("p1", airplane[2]);
        assertEquals("40", airplane[3]);
        assertEquals("50", airplane[4]);
        assertEquals("60", airplane[5]);
        assertEquals("15", airplane[6]);
        assertEquals("10", airplane[7]);
        assertEquals("5", airplane[8]);
        assertEquals("Southwest", airplane[9]);
        assertEquals("1234", airplane[10]);
        assertEquals("2", airplane[11]);

        assertEquals("add", rocket[0]);
        assertEquals("rocket", rocket[1]);
        assertEquals("r1", rocket[2]);
        assertEquals("70", rocket[3]);
        assertEquals("80", rocket[4]);
        assertEquals("90", rocket[5]);
        assertEquals("5", rocket[6]);
        assertEquals("5", rocket[7]);
        assertEquals("15", rocket[8]);
        assertEquals("50", rocket[9]);
        assertEquals("45.5", rocket[10]);

        assertEquals("add", drone[0]);
        assertEquals("drone", drone[1]);
        assertEquals("d1", drone[2]);
        assertEquals("100", drone[3]);
        assertEquals("110", drone[4]);
        assertEquals("120", drone[5]);
        assertEquals("5", drone[6]);
        assertEquals("5", drone[7]);
        assertEquals("5", drone[8]);
        assertEquals("Amazon", drone[9]);
        assertEquals("4", drone[10]);

        assertEquals("add", bird[0]);
        assertEquals("bird", bird[1]);
        assertEquals("bi1", bird[2]);
        assertEquals("130", bird[3]);
        assertEquals("140", bird[4]);
        assertEquals("150", bird[5]);
        assertEquals("10", bird[6]);
        assertEquals("10", bird[7]);
        assertEquals("10", bird[8]);
        assertEquals("Dinosaur", bird[9]);
        assertEquals("10", bird[10]);

        assertEquals("delete", delete[0]);
        assertEquals("del1", delete[1]);

        assertEquals("print", printSL[0]);
        assertEquals("skiplist", printSL[1]);

        assertEquals("print", printBT[0]);
        assertEquals("bintree", printBT[1]);

        assertEquals("print", printObj[0]);
        assertEquals("object", printObj[1]);
        assertEquals("obj1", printObj[2]);

        assertEquals("rangeprint", rangeprint[0]);
        assertEquals("1", rangeprint[1]);
        assertEquals("2", rangeprint[2]);

        assertEquals("collisions", collisions[0]);

        assertEquals("intersect", intersect[0]);
        assertEquals("1", intersect[1]);
        assertEquals("2", intersect[2]);
        assertEquals("3", intersect[3]);
        assertEquals("4", intersect[4]);
        assertEquals("5", intersect[5]);
        assertEquals("6", intersect[6]);
    }

}
