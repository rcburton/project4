// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author sayanray
 *  @version Nov 29, 2018
 */
public class VarLeafNode implements VarBinNode
{
    private Item val;
    private int lf;
    public VarLeafNode(Item obj) {
        this.lf = 0;
        this.val = obj;
    }

    // ----------------------------------------------------------
    /**
     * Get the current value of val.
     * @return The value of val for this object.
     */
    public Item getItem()
    {
        return val;
    }

    // ----------------------------------------------------------
    /**
     * Set the value of val for this object.
     * @param val The new value for val.
     */
    public void setItem(Item val)
    {
        this.val = val;
    }

    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf()
    {
        if(lf == 0) {
        return true;
        }
        return false;
    }

    // ----------------------------------------------------------
    /**
     * Get the current value of lf.
     * @return The value of lf for this object.
     */
    public int getLf()
    {
        return lf;
    }

    // ----------------------------------------------------------
    /**
     * Set the value of lf for this object.
     * @param lf The new value for lf.
     */
    public void setLf(int lf)
    {
        this.lf = lf;
    }




}
