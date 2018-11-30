// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 29, 2018
 */
public class BinTree
{
    private VarBinNode root;



    public BinTree()
    {
        root = VarFlyWeight.getInstance();

    }




    private VarBinNode insert(Item item)
    {
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        return insertHelp(item, root, b, 0);

    }


    private VarBinNode insertHelp(Item item, VarBinNode x, Box xbox, int level)
    {

        if (x == VarFlyWeight.getInstance() )
        {

            ((VarFlyWeight)x).turnLeaf(); //turn into leaf
            ((VarLeafNode)x).setItem(item);
            return x;
        }
        if (x.isLeaf())
        {
            Item temp = ((VarLeafNode)x).getItem();
            ((VarLeafNode)x).setLf(1); //turn into internal node
            ((VarIntlNode)x).setLeft(VarFlyWeight.getInstance());
            ((VarIntlNode)x).setRight(VarFlyWeight.getInstance());
            insertHelp(temp, x, xbox, level);
            insertHelp(item, x, xbox, level);

        }
        else
        {
            level++;
            Box[] cube = xbox.split(level % 3);
            if (searchHelp(item, cube[0]))
            {
                insertHelp(item, ((VarIntlNode)x).getRight(), cube[0], level);
            }
            else
            {
                insertHelp(item, ((VarIntlNode)x).getLeft(), cube[1], level);
            }

        }
        return x;
    }


    private boolean searchHelp(Item item, Box b)
    {
        if (item.getAirObj().getXorig() <= b.getxMax()
            && item.getAirObj().getXorig() >= b.getxMin()
            && item.getAirObj().getYorig() <= b.getyMax()
            && item.getAirObj().getYorig() >= b.getyMin()
            && item.getAirObj().getZorig() <= b.getzMax()
            && item.getAirObj().getZorig() >= b.getzMin())

        {
            return true;
        }
        return false;
    }


// ----------------------------------------------------------
    /**
     * Get the current value of root.
     *
     * @return The value of root for this object.
     */
    public VarBinNode getRoot()
    {
        return root;
    }


// ----------------------------------------------------------
    /**
     * Set the value of root for this object.
     *
     * @param root
     *            The new value for root.
     */
    public void setRoot(VarBinNode root)
    {
        this.root = root;
    }



}
