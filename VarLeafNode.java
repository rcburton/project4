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
    public VarLeafNode(Item obj) {
        this.val = obj;
    }

    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf()
    {
        // TODO Auto-generated method stub
        return true;
    }

    public Item getItem() {
        return val;

    }



}
