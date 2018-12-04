// -------------------------------------------------------------------------
/**
 * BinTree for the AirControl
 *
 * @author sayanray
 * @version Nov 29, 2018
 */
public class BinTree {
    private VarBinNode root;


    /**
     * BinTree constructor
     */
    public BinTree() {
        root = VarFlyWeight.getInstance();

    }


    /**
     * Insert function for the BinTree
     *
     * @param item
     *            item being inserted
     * @return
     *         the inserted VarBinNode item
     */
    public VarBinNode insert(Item item) {
        Box b = new Box(1024, 0, 1024, 0, 1024, 0);
        return insertHelp(item, root, b, 0);

    }


    /**
     * Assists with the BinTree insert
     * Adds the item to a flyweight if it hits one during recursion
     * and returns the node . If it encounters a leafNode then it calls
     * leafNode's insert and if it is an internal node it splits the current box
     * and checks which box contains the item's coordinates and calls the recursive
     * insertHelp accordingly
     *
     * @param item
     *            Item being inserted
     * @param x
     *            VarBinNode
     * @param xbox
     *            relevant Box
     * @param level
     *            current tree level
     * @return
     *         The relevant VarBinNode
     */
    private VarBinNode insertHelp(
        Item item,
        VarBinNode x,
        Box xbox,
        int level) {

        if (x == VarFlyWeight.getInstance()) {

            ((VarFlyWeight)x).turnLeaf(); // turn into leaf
            ((VarLeafNode)x).insert(item, x);
            return x;
        }
        if (x.isLeaf()) {
            ((VarLeafNode)x).insert(item, x);
        }
        else {
            level++;
            Box[] cube = xbox.split(level % 3);
            if (searchHelp(item, cube[0])) {
                insertHelp(item, ((VarIntlNode)x).getRight(), cube[0], level);
            }
            else {
                insertHelp(item, ((VarIntlNode)x).getLeft(), cube[1], level);
            }

        }
        return x;
    }


    /**
     * Assists searching for items in the BinTree
     * Checks if the co-ordinates of the item is is contained
     * in the box
     * @param item
     *            The item being searched for
     * @param b
     *            The box containing the item
     * @return
     *         If the item was found in the given box
     */
    private boolean searchHelp(Item item, Box b) {
        return (item.getAirObj().getXorig() <= b.getxMax() && item.getAirObj()
            .getXorig() >= b.getxMin() && item.getAirObj().getYorig() <= b
                .getyMax() && item.getAirObj().getYorig() >= b.getyMin() && item
                    .getAirObj().getZorig() <= b.getzMax() && item.getAirObj()
                        .getZorig() >= b.getzMin());
    }


// ----------------------------------------------------------
    /**
     * Get the current value of root.
     *
     * @return The value of root for this object.
     */
    public VarBinNode getRoot() {
        return root;
    }


// ----------------------------------------------------------
    /**
     * Set the value of root for this object.
     *
     * @param root
     *            The new value for root.
     */
    public void setRoot(VarBinNode root) {
        this.root = root;
    }

}
