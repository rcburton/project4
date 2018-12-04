// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 29, 2018
 */
public class Box {
    private int xMax;
    private int xMin;
    private int yMax;
    private int yMin;
    private int zMax;
    private int zMin;


    /**
     * Box Constructor
     *
     * @param maxX
     *            max X value
     * @param minX
     *            min X value
     * @param maxY
     *            max Y value
     * @param minY
     *            min Y value
     * @param maxZ
     *            max Z value
     * @param minZ
     *            min Z value
     */
    public Box(int maxX, int minX, int maxY, int minY, int maxZ, int minZ) {
        this.xMax = maxX;
        this.xMin = minX;
        this.yMax = maxY;
        this.yMin = minY;
        this.zMax = maxZ;
        this.zMin = minZ;
    }


    /**
     * Splits a box according to the value of the
     * axis passed in
     * 0 if x-axis
     * 1 if y-axis
     * 2 if z-axis
     * @param axis
     *            axis where the split is occurring
     * @return
     *         the Box array of the split Box
     */
    public Box[] split(int axis) {
        Box[] box2 = new Box[2];
        // split x axis
        if (axis == 1) {
            box2[0] = new Box(xMax, (xMax + xMin) / 2, yMax, yMin, zMax, zMin);
            box2[1] = new Box((xMax + xMin) / 2, xMin, yMax, yMin, zMax, zMin);
        }
        // split y axis
        if (axis == 2) {
            box2[0] = new Box(xMax, xMin, yMax, (yMax + yMin) / 2, zMax, zMin);
            box2[1] = new Box(xMax, xMin, (yMax + yMin) / 2, yMin, zMax, zMin);
        }
        // split z axis
        if (axis == 3) {
            box2[0] = new Box(xMax, xMin, yMax, yMin, zMax, (zMax + zMin) / 2);
            box2[1] = new Box(xMax, xMin, yMax, yMin, (zMax + zMin) / 2, zMin);
        }
        return box2;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of xMax.
     *
     * @return The value of xMax for this object.
     */
    public int getxMax() {
        return xMax;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of xMax for this object.
     *
     * @param xMax
     *            The new value for xMax.
     */
    public void setxMax(int xMax) {
        this.xMax = xMax;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of xMin.
     *
     * @return The value of xMin for this object.
     */
    public int getxMin() {
        return xMin;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of xMin for this object.
     *
     * @param xMin
     *            The new value for xMin.
     */
    public void setxMin(int xMin) {
        this.xMin = xMin;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of yMax.
     *
     * @return The value of yMax for this object.
     */
    public int getyMax() {
        return yMax;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of yMax for this object.
     *
     * @param yMax
     *            The new value for yMax.
     */
    public void setyMax(int yMax) {
        this.yMax = yMax;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of yMin.
     *
     * @return The value of yMin for this object.
     */
    public int getyMin() {
        return yMin;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of yMin for this object.
     *
     * @param yMin
     *            The new value for yMin.
     */
    public void setyMin(int yMin) {
        this.yMin = yMin;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of zMax.
     *
     * @return The value of zMax for this object.
     */
    public int getzMax() {
        return zMax;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of zMax for this object.
     *
     * @param zMax
     *            The new value for zMax.
     */
    public void setzMax(int zMax) {
        this.zMax = zMax;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of zMin.
     *
     * @return The value of zMin for this object.
     */
    public int getzMin() {
        return zMin;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of zMin for this object.
     *
     * @param zMin
     *            The new value for zMin.
     */
    public void setzMin(int zMin) {
        this.zMin = zMin;
    }

}
