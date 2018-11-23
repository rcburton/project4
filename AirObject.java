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


    public AirObject() {

    }


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

}
