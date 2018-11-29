// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author sayanray
 *  @version Nov 29, 2018
 */
public class VarFlyWeight implements VarBinNode
{
    private static final VarFlyWeight flyweight = new VarFlyWeight();
    private VarFlyWeight() {
        //nothing to do
    }

    public static VarFlyWeight getInstance() {
        return flyweight;
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
    //~ Fields ................................................................

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
