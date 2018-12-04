// -------------------------------------------------------------------------
/**
 * VarFlyWeight class
 *
 * @author sayanray
 * @version Nov 29, 2018
 */
public class VarFlyWeight
    implements VarBinNode
{
    private int                 flyLeaf;
    private static VarFlyWeight flyweight = new VarFlyWeight();


    /**
     * Constructor
     */
    private VarFlyWeight()
    {
        flyLeaf = 0;
    }


    /**
     * Returns the VarFlyWeight
     * @return
     * the VarFlyWeight
     */
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
        return (flyLeaf == 1);
    }
    // ~ Fields ................................................................


    // ----------------------------------------------------------
   
    /**
     * Converts and object to a VarFlyWeight
     */
    public void turnLeaf()
    {
        flyLeaf = 1;

    }

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
