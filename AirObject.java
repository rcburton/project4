/**
 * The class containing the AirObjects.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class AirObject {

    private int xOrigin;
    private int yOrigin;
    private int zOrigin;
    private int xWidth;
    private int yWidth;
    private int zWidth;
    private String name;


    /**
     * Constructor
     * 
     * @param name
     *            AirObject name
     * @param x
     *            X coordinate
     * @param y
     *            Y coordinate
     * @param z
     *            Z coordinate
     * @param xWidth
     *            X width
     * @param yWidth
     *            Y width
     * @param zWidth
     *            Z width
     */
    public AirObject(
        String name,
        int x,
        int y,
        int z,
        int xWidth,
        int yWidth,
        int zWidth) {
        this.name = name;
        this.xOrigin = x;
        this.yOrigin = y;
        this.zOrigin = z;
        this.xWidth = xWidth;
        this.yWidth = yWidth;
        this.zWidth = zWidth;
    }


    /**
     * Getter for X coordinate
     * 
     * @return
     *         X coordinate
     */
    public int getXorig() {
        return this.xOrigin;
    }


    /**
     * Getter for Y coordinate
     * 
     * @return
     *         Y coordinate
     */
    public int getYorig() {
        return this.yOrigin;
    }


    /**
     * Getter for Z coordinate
     * 
     * @return
     *         Z coordinate
     */
    public int getZorig() {
        return this.zOrigin;
    }


    /**
     * Getter for X width
     * 
     * @return
     *         X width
     */
    public int getXwidth() {
        return this.xWidth;
    }


    /**
     * Getter for Y width
     * 
     * @return
     *         Y width
     */
    public int getYwidth() {
        return this.yWidth;
    }


    /**
     * Getter for Z width
     * 
     * @return
     *         Z width
     */
    public int getZwidth() {
        return this.zWidth;
    }


    /**
     * Getter for name
     * 
     * @return
     *         name
     */
    public String getName() {
        return this.name;
    }

}
