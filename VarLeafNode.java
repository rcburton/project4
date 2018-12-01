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


    public void insert(Item tem)
    {
        if (size >= 3 && isSplitNeeded(tem)) {
            //split and reinsert
        }
        else {
            //just add item at val[size]
        }

    }


    public boolean isSplitNeeded(Item temp)
    {
        boolean intersect = false;
        boolean xIntersect = false;
        boolean yIntersect = false;
        boolean zIntersect = false;
        for (int i = 0; i < size; i++)
        {

            Item i1 = val[i];

            Item j1 = temp;
            Item a;
            Item b;
            // calculate intersection box
            if (i1.getAirObj().getXorig() < j1.getAirObj().getXorig())
            {
                a = j1;
                b = i1;
            }
            else
            {
                a = i1;
                b = j1;
            }

            if ((a.getAirObj().getXorig() + a.getAirObj().getXwidth()
                - b.getAirObj().getXorig()) <= (a.getAirObj().getXwidth()
                    + b.getAirObj().getXwidth()))
            {
                xIntersect = true;
            }

            if (i1.getAirObj().getYorig() < j1.getAirObj().getYorig())
            {

                // calculate intersection box
                if (i1.getAirObj().getYorig() < j1.getAirObj().getYorig())
                {
                    a = j1;
                    b = i1;
                }
                else
                {
                    a = i1;
                    b = j1;
                }
                if ((a.getAirObj().getYorig() + a.getAirObj().getYwidth()
                    - b.getAirObj().getYorig()) <= (a.getAirObj().getYwidth()
                        + b.getAirObj().getYwidth()))
                {
                    yIntersect = true;
                }
            }
            if (i1.getAirObj().getZorig() < j1.getAirObj().getZorig())
            {

                // calculate intersection box
                if (i1.getAirObj().getZorig() < j1.getAirObj().getZorig())
                {
                    a = j1;
                    b = i1;
                }
                else
                {
                    a = i1;
                    b = j1;
                }
                if ((a.getAirObj().getZorig() + a.getAirObj().getZwidth()
                    - b.getAirObj().getZorig()) <= (a.getAirObj().getZwidth()
                        + b.getAirObj().getZwidth()))
                {
                    zIntersect = true;
                }
            }

            intersect = (xIntersect || yIntersect || zIntersect);
            if (!intersect)
            {
                break;
            }
            intersect = false;
            xIntersect = false;
            yIntersect = false;
            zIntersect = false;
        }

        return !intersect;
    }
}
