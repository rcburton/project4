// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 29, 2018
 */
public class VarLeafNode
    implements VarBinNode
{

    private int    lf;
    private Box    box;
    private Item[] val;
    private int    size;


    public VarLeafNode(Box b1)
    {
        this.lf = 0;
        this.box = b1;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of val.
     *
     * @return The value of val for this object.
     */
    public Item[] getItem()
    {
        return val;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf()
    {
        if (lf == 0)
        {
            return true;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of lf.
     *
     * @return The value of lf for this object.
     */
    public int getLf()
    {
        return lf;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of lf for this object.
     *
     * @param lf
     *            The new value for lf.
     */
    public void setLf(int lf)
    {
        this.lf = lf;
    }


    public void insert(Item tem, VarBinNode x)
    {
        int length = this.getItem().length;
        boolean intersect = true;
        if (size >= 3)
        {
            for (int i = 0; i < length; i++)
            {
                intersect &= doesIntersect(val[i], tem);
                if (!intersect)
                {
                    break;
                }
            }
            if (intersect == false)
            {

                Item[] temp = ((VarLeafNode)x).getItem();
                ((VarLeafNode)x).setLf(1); // turn into internal node
                ((VarIntlNode)x).setLeft(VarFlyWeight.getInstance());
                ((VarIntlNode)x).setRight(VarFlyWeight.getInstance());
                for (int i = 0; i < size; i++)
                {
                    ((BinTree)x).insert(temp[i]);
                }
                ((BinTree)x).insert(tem);

            }
        }
        else
        {
            val[size] = tem;
            size++;
        }
        // have a for loop to check intersection of tem with all the items
// if (size >= 3 && isSplitNeeded(tem)) {
// //split and reinsert
// }
// else {
// //just add item at val[size]
// }

    }


    // ----------------------------------------------------------
    /**
     * Get the current value of box.
     *
     * @return The value of box for this object.
     */
    public Box getBox()
    {
        return box;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of box for this object.
     *
     * @param box
     *            The new value for box.
     */
    public void setBox(Box box)
    {
        this.box = box;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of val.
     *
     * @return The value of val for this object.
     */
    public Item[] getVal()
    {
        return val;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of val for this object.
     *
     * @param val
     *            The new value for val.
     */
    public void setVal(Item[] val)
    {
        this.val = val;
    }


    // ----------------------------------------------------------
    /**
     * Get the current value of size.
     *
     * @return The value of size for this object.
     */
    public int getSize()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Set the value of size for this object.
     *
     * @param size
     *            The new value for size.
     */
    public void setSize(int size)
    {
        this.size = size;
    }


    public boolean doesIntersect(Item item1, Item item2)
    {
        boolean intersect = false;
        boolean xIntersect = false;
        boolean yIntersect = false;
        boolean zIntersect = false;
        Item a;
        Item b;
        // calculate intersection box
        if (item1.getAirObj().getXorig() < item2.getAirObj().getXorig())
        {
            a = item2;
            b = item1;
        }
        else
        {
            a = item1;
            b = item2;
        }

        if ((a.getAirObj().getXorig() + a.getAirObj().getXwidth()
            - b.getAirObj().getXorig()) <= (a.getAirObj().getXwidth()
                + b.getAirObj().getXwidth()))
        {
            xIntersect = true;
        }
        //////////////////////////////////
        if (item1.getAirObj().getZorig() < item2.getAirObj().getZorig())
        {
            a = item2;
            b = item1;
        }
        else
        {
            a = item1;
            b = item2;
        }

        if ((a.getAirObj().getZorig() + a.getAirObj().getZwidth()
            - b.getAirObj().getZorig()) <= (a.getAirObj().getZwidth()
                + b.getAirObj().getZwidth()))
        {
            zIntersect = true;
        }
        //////////////////////////////
        if (item1.getAirObj().getYorig() < item2.getAirObj().getYorig())
        {
            a = item2;
            b = item1;
        }
        else
        {
            a = item1;
            b = item2;
        }

        if ((a.getAirObj().getYorig() + a.getAirObj().getYwidth()
            - b.getAirObj().getYorig()) <= (a.getAirObj().getYwidth()
                + b.getAirObj().getYwidth()))
        {
            yIntersect = true;
        }

        intersect = (xIntersect || yIntersect || zIntersect);

        return intersect;
    }
}
