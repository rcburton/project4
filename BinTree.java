// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author sayanray
 *  @version Nov 29, 2018
 */
public class BinTree
{
   private VarBinNode root;
   private Box world;
   public BinTree(Box b1) {
       root = VarFlyWeight.getInstance();
       this.world  = b1;
   }
   public void insert() {

   }
   private int level(VarBinNode nd) {
       int level = 0;
       int leftLevel = 0;
       int rightLevel = 0;
       if(nd == VarFlyWeight.getInstance()) {
           return level;
       }
       else {
       leftLevel = level(((VarIntlNode)nd).getLeft());
       rightLevel = level(((VarIntlNode)nd).getRight());
       return 1 + Math.max(leftLevel, rightLevel);
       }

       }




}
