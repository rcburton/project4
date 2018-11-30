// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 29, 2018
 */
public class VarFlyWeight
    implements VarBinNode
{
    private int                 flyLeaf;
    private static VarFlyWeight flyweight = new VarFlyWeight();


    private VarFlyWeight()
    {
        flyLeaf = 0;
    }


    public static VarFlyWeight getInstance()
    {
        return flyweight;
    }


    // ----------------------------------------------------------
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeaf()
    {
        if (flyLeaf == 1)
        {
            return true;
        }
        return false;
    }
    // ~ Fields ................................................................


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param item
     */
    public void turnLeaf()
    {
        flyLeaf = 1;

    }

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
