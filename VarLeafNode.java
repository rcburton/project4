// -------------------------------------------------------------------------
/**
 * Leaf nodes for the BinTree
 *
 * @author sayanray and Ryan Burton
 * @version Nov 29, 2018
 */
public class VarLeafNode implements VarBinNode {

    private int lf;
    private Box box;
    private Item[] val;
    private int size;


    /**
     * Constructor
     *
     * @param b1
     *            box for the new leaf
     */
    public VarLeafNode(Box b1) {
        this.lf = 0;
        this.box = b1;
        this.val = new Item[1024];
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of val.
     *
     * @return The value of val for this object.
     */
    public Item[] getItem() {
        return val;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf() {
        return (lf == 0);
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of lf.
     *
     * @return The value of lf for this object.
     */
    public int getLf() {
        return lf;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of lf for this object.
     *
     * @param lf
     *            The new value for lf.
     */
    public void setLf(int lf) {
        this.lf = lf;
    }


    /**
     * Inserts the item object to the leaf node if
     * it intersects with all the other items present
     * in the leaf node. If not, it turns the leafNode
     * into an internal node and re-inserts all the objects
     * formerly present in the leaf node plus the new item
     *
     * @param tem
     *            object being inserted
     * @param x
     *            VarBinNode
     * @return
     *         The updated BinNode
     */
    public VarIntlNode insert(Item tem, VarBinNode x) {
        if (this.getSize() >= 3) {
            int length = this.getItem().length;
            boolean intersect = true;
            for (int i = 0; i < length; i++) {
                intersect &= doesIntersect(val[i], tem);
                if (!intersect) {
                    break;
                }
            }
            if (!intersect) {
                VarIntlNode vin = new VarIntlNode(VarFlyWeight.getInstance(),
                    VarFlyWeight.getInstance());
                Item[] temp = ((VarLeafNode)x).getItem();

                vin.setLeft(VarFlyWeight.getInstance());
                vin.setRight(VarFlyWeight.getInstance());
                for (int i = 0; i < size; i++) {

                }

                return vin;
            }
        }
        else {
            val[size] = tem;
            size++;
        }
        return null;


    }


    // ----------------------------------------------------------
    /**
     * Get the current value of box.
     *
     * @return The value of box for this object.
     */
    public Box getBox() {
        return box;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of box for this object.
     *
     * @param box
     *            The new value for box.
     */
    public void setBox(Box box) {
        this.box = box;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of val.
     *
     * @return The value of val for this object.
     */
    public Item[] getVal() {
        return val;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of val for this object.
     *
     * @param val
     *            The new value for val.
     */
    public void setVal(Item[] val) {
        this.val = val;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of size.
     *
     * @return The value of size for this object.
     */
    public int getSize() {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of size for this object.
     *
     * @param size
     *            The new value for size.
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Checks if two items intersect
     * @param item1
     * first item
     * @param item2
     * second item
     * @return
     * if the items intersect
     */
    public boolean doesIntersect(Item item1, Item item2) {
        boolean intersect = false;
        boolean xIntersect = false;
        boolean yIntersect = false;
        boolean zIntersect = false;
        Item a;
        Item b;
        // calculate intersection box
        if (item1.getAirObj().getXorig() < item2.getAirObj().getXorig()) {
            a = item2;
            b = item1;
        }
        else {
            a = item1;
            b = item2;
        }

        if ((a.getAirObj().getXorig() + a.getAirObj().getXwidth() - b
            .getAirObj().getXorig()) <= (a.getAirObj().getXwidth() + b
                .getAirObj().getXwidth())) {
            xIntersect = true;
        }
        //////////////////////////////////
        if (item1.getAirObj().getZorig() < item2.getAirObj().getZorig()) {
            a = item2;
            b = item1;
        }
        else {
            a = item1;
            b = item2;
        }

        if ((a.getAirObj().getZorig() + a.getAirObj().getZwidth() - b
            .getAirObj().getZorig()) <= (a.getAirObj().getZwidth() + b
                .getAirObj().getZwidth())) {
            zIntersect = true;
        }
        //////////////////////////////
        if (item1.getAirObj().getYorig() < item2.getAirObj().getYorig()) {
            a = item2;
            b = item1;
        }
        else {
            a = item1;
            b = item2;
        }

        if ((a.getAirObj().getYorig() + a.getAirObj().getYwidth() - b
            .getAirObj().getYorig()) <= (a.getAirObj().getYwidth() + b
                .getAirObj().getYwidth())) {
            yIntersect = true;
        }

        intersect = (xIntersect || yIntersect || zIntersect);

        return intersect;
    }
}
