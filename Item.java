/**
 * The class containing the Item.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class Item {

    private AirObject airObj;
    private String aoType;
    private String type;
    private int ascendRate;
    private String carrier;
    private int flightNum;
    private int engineNum;
    private double trajectory;
    private String brand;
    private int number;
    private String name;


    /**
     * Constructor
     * 
     * @param parsedData
     *            The parsed data used to construct the Item
     */
    public Item(String[] parsedData) {
        this.airObj = new AirObject(parsedData[2], Integer.parseInt(
            parsedData[3]), Integer.parseInt(parsedData[4]), Integer.parseInt(
                parsedData[5]), Integer.parseInt(parsedData[6]), Integer
                    .parseInt(parsedData[7]), Integer.parseInt(parsedData[8]));
        this.name = parsedData[2];
        if (parsedData[1].equals("balloon")) {
            this.aoType = parsedData[1];
            this.type = parsedData[9];
            this.ascendRate = Integer.parseInt(parsedData[10]);
        }
        else if (parsedData[1].equals("airplane")) {
            this.aoType = parsedData[1];
            this.carrier = parsedData[9];
            this.flightNum = Integer.parseInt(parsedData[10]);
            this.engineNum = Integer.parseInt(parsedData[11]);

        }
        else if (parsedData[1].equals("rocket")) {
            this.aoType = parsedData[1];
            this.ascendRate = Integer.parseInt(parsedData[9]);
            this.trajectory = Double.parseDouble(parsedData[10]);

        }
        else if (parsedData[1].equals("drone")) {
            this.aoType = parsedData[1];
            this.brand = parsedData[9];
            this.engineNum = Integer.parseInt(parsedData[10]);

        }
        else if (parsedData[1].equals("bird")) {
            this.aoType = parsedData[1];
            this.type = parsedData[9];
            this.number = Integer.parseInt(parsedData[10]);
        }

    }


    /**
     * Getter for the AirObject
     * 
     * @return
     *         The AirObject
     */
    public AirObject getAirObj() {
        return this.airObj;
    }


    /**
     * Getter for the Name
     * 
     * @return
     *         The Name
     */
    public String getName() {
        return this.name;
    }


    /**
     * Getter for the AirObject type
     * 
     * @return
     *         The AOType
     */
    public String getAOType() {
        return this.aoType;
    }


    /**
     * Getter for the type
     * 
     * @return
     *         The type
     */
    public String getType() {
        return this.type;
    }


    /**
     * Getter for the ascend rate
     * 
     * @return
     *         The Ascend Rate
     */
    public int getAscendRate() {
        return this.ascendRate;
    }


    /**
     * Getter for the carrier
     * 
     * @return
     *         The carrier
     */
    public String getCarrier() {
        return this.carrier;
    }


    /**
     * Getter for the flight number
     * 
     * @return
     *         The flight number
     */
    public int getFlightNum() {
        return this.flightNum;
    }


    /**
     * Getter for the engine number
     * 
     * @return
     *         The engine number
     */
    public int getEngineNum() {
        return this.engineNum;
    }


    /**
     * Getter for the trajectory
     * 
     * @return
     *         The trajectory
     */
    public double getTrajectory() {
        return this.trajectory;
    }


    /**
     * Getter for the brand
     * 
     * @return
     *         The brand
     */
    public String getBrand() {
        return this.brand;
    }


    /**
     * Getter for the number
     * 
     * @return
     *         The number
     */
    public int getNumber() {
        return this.number;
    }


    /**
     * Outputs the Item as a String
     * 
     * @return
     *         The String
     */
    public String toString() {
        String outStr = "";
        // implement toString
        if (this.getAOType().equals("balloon")) {
            outStr = "Balloon " + this.getName() + " " + Integer.toString(this
                .getAirObj().getXorig()) + " " + Integer.toString(this
                    .getAirObj().getYorig()) + " " + Integer.toString(this
                        .getAirObj().getZorig()) + " " + Integer.toString(this
                            .getAirObj().getXwidth()) + " " + Integer.toString(
                                this.getAirObj().getYwidth()) + " " + Integer
                                    .toString(this.getAirObj().getZwidth())
                + " " + this.getType() + " " + Integer.toString(this
                    .getAscendRate());
        }
        else if (this.getAOType().equals("airplane")) {
            outStr = "Airplane " + this.getName() + " " + Integer.toString(this
                .getAirObj().getXorig()) + " " + Integer.toString(this
                    .getAirObj().getYorig()) + " " + Integer.toString(this
                        .getAirObj().getZorig()) + " " + Integer.toString(this
                            .getAirObj().getXwidth()) + " " + Integer.toString(
                                this.getAirObj().getYwidth()) + " " + Integer
                                    .toString(this.getAirObj().getZwidth())
                + " " + this.getCarrier() + " " + Integer.toString(this
                    .getFlightNum()) + " " + Integer.toString(this
                        .getEngineNum());

        }
        else if (this.getAOType().equals("rocket")) {
            outStr = "Rocket " + this.getName() + " " + Integer.toString(this
                .getAirObj().getXorig()) + " " + Integer.toString(this
                    .getAirObj().getYorig()) + " " + Integer.toString(this
                        .getAirObj().getZorig()) + " " + Integer.toString(this
                            .getAirObj().getXwidth()) + " " + Integer.toString(
                                this.getAirObj().getYwidth()) + " " + Integer
                                    .toString(this.getAirObj().getZwidth())
                + " " + Integer.toString(this.getAscendRate()) + " " + Double
                    .toString(this.getTrajectory());

        }
        else if (this.getAOType().equals("drone")) {
            outStr = "Drone " + this.getName() + " " + Integer.toString(this
                .getAirObj().getXorig()) + " " + Integer.toString(this
                    .getAirObj().getYorig()) + " " + Integer.toString(this
                        .getAirObj().getZorig()) + " " + Integer.toString(this
                            .getAirObj().getXwidth()) + " " + Integer.toString(
                                this.getAirObj().getYwidth()) + " " + Integer
                                    .toString(this.getAirObj().getZwidth())
                + " " + this.getBrand() + " " + Integer.toString(this
                    .getEngineNum());

        }
        else if (this.getAOType().equals("bird")) {
            outStr = "Bird " + this.getName() + " " + Integer.toString(this
                .getAirObj().getXorig()) + " " + Integer.toString(this
                    .getAirObj().getYorig()) + " " + Integer.toString(this
                        .getAirObj().getZorig()) + " " + Integer.toString(this
                            .getAirObj().getXwidth()) + " " + Integer.toString(
                                this.getAirObj().getYwidth()) + " " + Integer
                                    .toString(this.getAirObj().getZwidth())
                + " " + this.getType() + " " + Integer.toString(this
                    .getNumber());

        }
        return outStr;
    }

}
