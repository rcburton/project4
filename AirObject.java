/**
 * 
 */

/**
 * @author Ryan
 *
 */
public class AirObject {
    
    private int xOrigin;
    private int yOrigin;
    private int zOrigin;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private String name;
    
    private String aoType;
    private String type;
    private int ascendRate;
    private String carrier;
    private int flightNum;
    private int engineNum;
    private double trajectory;
    private String brand;
    private int number;
    
    public AirObject() {
        
    }
    public AirObject(String name, int x, int y, int z, int xWidth, int yWidth, int zWidth, String strIn, int intIn, String aoType) {
        if(aoType.equals("balloon")) {
            this.aoType = "balloon";
            this.type = strIn;
            this.ascendRate = intIn;
        }
        else if(aoType.equals("drone")) {
            this.aoType = "drone";
            this.brand = strIn;
            this.engineNum = intIn;
        }
        else if(aoType.equals("bird")) {
            this.aoType = "bird";
            this.type = strIn;
            this.number = intIn;
        }
        else {
            //input error
        }
        this.name = name;
        this.xOrigin = x;
        this.yOrigin = y;
        this.zOrigin = z;
        this.xWidth = xWidth;
        this.yWidth = yWidth;
        this.zWidth = zWidth;
    }
    public AirObject(String name, int x, int y, int z, int xWidth, int yWidth, int zWidth, String carrier, int flightNum, int engineNum) {
        this.name = name;
        this.aoType = "airplane";
        this.carrier = carrier;
        this.flightNum = flightNum;
        this.engineNum = engineNum;
        this.xOrigin = x;
        this.yOrigin = y;
        this.zOrigin = z;
        this.xWidth = xWidth;
        this.yWidth = yWidth;
        this.zWidth = zWidth;
        
    }
    public AirObject(String name, int x, int y, int z, int xWidth, int yWidth, int zWidth, int ascendRate, double trajectory) {
        this.name = name;
        this.aoType = "rocket";
        this.ascendRate = ascendRate;
        this.trajectory = trajectory;
        this.xOrigin = x;
        this.yOrigin = y;
        this.zOrigin = z;
        this.xWidth = xWidth;
        this.yWidth = yWidth;
        this.zWidth = zWidth;
    
    }
    
    public int getXorig() {
        return this.xOrigin;
    }
    public int getYorig() {
        return this.yOrigin;
    }
    public int getZorig() {
        return this.zOrigin;
    }
    public int getXwidth() {
        return this.xWidth;
    }
    public int getYwidth() {
        return this.yWidth;
    }
    public int getZwidth() {
        return this.zWidth;
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
