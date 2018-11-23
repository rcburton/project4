
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


    public AirObject getAirObj() {
        return this.airObj;
    }


    public String getName() {
        return this.name;
    }


    public String getAOType() {
        return this.aoType;
    }


    public String getType() {
        return this.type;
    }


    public int getAscendRate() {
        return this.ascendRate;
    }


    public String getCarrier() {
        return this.carrier;
    }


    public int getFlightNum() {
        return this.flightNum;
    }


    public int getEngineNum() {
        return this.engineNum;
    }


    public double getTrajectory() {
        return this.trajectory;
    }


    public String getBrand() {
        return this.brand;
    }


    public int getNumber() {
        return this.number;
    }

}
