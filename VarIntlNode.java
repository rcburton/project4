// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author sayanray
 *  @version Nov 29, 2018
 */
public class VarIntlNode implements VarBinNode
{
    private VarBinNode left;
    private VarBinNode right;
    public VarIntlNode(VarBinNode left, VarBinNode right) {
        this.left = left;
        this.right = right;
    }

    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf()
    {
        // TODO Auto-generated method stub
        return false;
    }

    // ----------------------------------------------------------
    /**
     * Get the current value of left.
     * @return The value of left for this object.
     */
    public VarBinNode getLeft()
    {
        return left;
    }

    // ----------------------------------------------------------
    /**
     * Set the value of left for this object.
     * @param left The new value for left.
     */
    public void setLeft(VarBinNode left)
    {
        this.left = left;
    }

    // ----------------------------------------------------------
    /**
     * Get the current value of right.
     * @return The value of right for this object.
     */
    public VarBinNode getRight()
    {
        return right;
    }

    // ----------------------------------------------------------
    /**
     * Set the value of right for this object.
     * @param right The new value for right.
     */
    public void setRight(VarBinNode right)
    {
        this.right = right;
    }
}
