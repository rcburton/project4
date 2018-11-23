import student.TestCase;

public class ItemTest extends TestCase {
    /**
     * Function to set up testing environment
     *
     */
    public void setUp() {
        // Nothing to set up
    }


    public void testInit() {
        Parser p = new Parser();

        String testBalloon = "add balloon ba1 10 20 30 5 10 15 hot_air 40";
        String testAirplane =
            "add airplane p1 40 50 60 15 10 5 Southwest 1234 2";
        String testRocket = "add rocket r1 70 80 90 5 5 15 50 45.5";
        String testDrone = "add drone d1 100 110 120 5 5 5 Amazon 4";
        String testBird = "add bird bi1 130 140 150 10 10 10 Dinosaur 10";

        String[] balloon = p.parseLine(testBalloon);
        String[] airplane = p.parseLine(testAirplane);
        String[] rocket = p.parseLine(testRocket);
        String[] drone = p.parseLine(testDrone);
        String[] bird = p.parseLine(testBird);

        Item balloonItem = new Item(balloon);
        Item airplaneItem = new Item(airplane);
        Item rocketItem = new Item(rocket);
        Item droneItem = new Item(drone);
        Item birdItem = new Item(bird);

        assertEquals("balloon", balloonItem.getAOType());
        assertEquals("hot_air", balloonItem.getType());
        assertEquals(40, balloonItem.getAscendRate());

        assertEquals("airplane", airplaneItem.getAOType());
        assertEquals("Southwest", airplaneItem.getCarrier());
        assertEquals(1234, airplaneItem.getFlightNum());
        assertEquals(2, airplaneItem.getEngineNum());

        assertEquals("rocket", rocketItem.getAOType());
        assertEquals(50, rocketItem.getAscendRate());
        assertEquals(45.5, rocketItem.getTrajectory(), 1);

        assertEquals("drone", droneItem.getAOType());
        assertEquals("Amazon", droneItem.getBrand());
        assertEquals(4, droneItem.getEngineNum());

        assertEquals("bird", birdItem.getAOType());
        assertEquals("Dinosaur", birdItem.getType());
        assertEquals(10, birdItem.getNumber());

    }

}
