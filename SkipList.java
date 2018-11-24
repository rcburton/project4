import java.util.Random;

// --------------------------------
class SkipNode
{
    private KVPair     rec;
    private SkipNode[] forward;
    private int        level;


    public Object element()
    {
        return rec.value();
    }


    public Comparable key()
    {
        return rec.key();
    }


    public int getLevel()
    {
        return this.level;
    }


    public SkipNode(Comparable key, Object elem, int level)
    {
        rec = new KVPair(key, elem);
        setForward(new SkipNode[level + 1]);
        for (int i = 0; i < level; i++)
            getForward()[i] = null;
        this.level = level;
    }


    public String toString()
    {
        return rec.toString();
    }


    /**
     * Get the current value of forward.
     *
     * @return The value of forward for this object.
     */
    public SkipNode[] getForward()
    {
        return forward;
    }


    /**
     * Set the value of forward for this object.
     *
     * @param forward
     *            The new value for forward.
     */
    public void setForward(SkipNode[] forward)
    {
        this.forward = forward;
    }
}




// ----------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 23, 2018
 */
public class SkipList
{
    private SkipNode      head;
    private int           level;
    private int           size;
    static private Random ran = new Random(); // Hold the Random class object


    public SkipList()
    {
        head = new SkipNode(null, null, 0);
        level = -1;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param key
     * @return
     */
    // Return the (first) matching matching element if one exists, null
    // otherwise
    public Object find(Comparable key)
    {
        SkipNode x = head; // Dummy header node
        for (int i = level; i >= 0; i--) // For each level...
            while ((x.getForward()[i] != null)
                && (x.getForward()[i].key().compareTo(key) < 0)) // go forward
                x = x.getForward()[i]; // Go one last step
        x = x.getForward()[0]; // Move to actual record, if it exists
        if ((x != null) && (x.key().compareTo(key) == 0))
            return x.element(); // Got it
        else
            return null; // Its not there
    }


    /** Insert a key, element pair into the skip list */
    public void insert(Comparable key, Object elem)
    {
        int newLevel = randomLevel(); // New node's level
        if (newLevel > level) // If new node is deeper
            adjustHead(newLevel); // adjust the header
        // Track end of level
        SkipNode[] update = new SkipNode[level + 1];
        SkipNode x = head; // Start at header node
        for (int i = level; i >= 0; i--)
        { // Find insert position
            while ((x.getForward()[i] != null)
                && (x.getForward()[i].key().compareTo(key) < 0))
                x = x.getForward()[i];
            update[i] = x; // Track end at level i
        }
        x = new SkipNode(key, elem, newLevel);
        for (int i = 0; i <= newLevel; i++)
        { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who points to x
        }
        size++; // Increment dictionary size
    }


    private void adjustHead(int newLevel)
    {
        SkipNode temp = head;
        head = new SkipNode(null, null, newLevel);
        for (int i = 0; i <= level; i++)
            head.getForward()[i] = temp.getForward()[i];
        level = newLevel;
    }


    int randomLevel()
    {
        int lev;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) // ran is random
                                                               // generator
            ; // Do nothing
        return lev;
    }


    public void delete(Comparable key)
    {
        SkipNode[] update = new SkipNode[level + 1];
        SkipNode x = head;
        for (int i = level; i >= 0; i--)
        { // For each level...
            while ((x.getForward()[i] != null)
                && (x.getForward()[i].key().compareTo(key) < 0))
            { // go forward
                x = x.getForward()[i];
            }
            update[i] = x;
        }
        x = x.getForward()[0];
        if ((x != null) && (x.key().compareTo(key) == 0))
        {
            // rearrange ptrs
            for (int i = 0; i <= level; i++)
            {
                if (update[i].getForward()[i] != x)
                {
                    break;
                }
                update[i].getForward()[i] = x.getForward()[i];
            }
            // remove levels with no elem
            while (level > 0 && head.getForward()[level] == null)
            {
                level--;
            }
            size--;
        }
    }


    public void print()
    {
        System.out.println("SkipList dump:");
        SkipNode x = head;
        while (x.getForward()[0] != null)
        {
            x = x.getForward()[0];
            String toPrint = "";
            toPrint += "Node has depth ";
            toPrint += Integer.toString(x.getLevel());
            toPrint += ", Value (";
            toPrint += x.element().toString();
            toPrint += ")";
            System.out.println(toPrint);
        }
        System.out.println(Integer.toString(size) + " skiplist nodes printed");
    }


    public void rangePrint(Comparable start, Comparable end)
    {
        if (start.compareTo(end) > 0)
        {
            System.out.println(
                "Error in rangeprint parameters: |" + start
                    + "| is not less than |" + end + "|");
        }
        else
        {
            System.out.println(
                "Found these records in the range |" + start + "| to |" + end
                    + "|");
            SkipNode x = head;
            while (x.getForward()[0] != null)
            {
                x = x.getForward()[0];
                if (start.compareTo(x.key()) >= 0
                    && end.compareTo(x.key()) <= 0)
                {
                    System.out.println(x.element().toString());
                }
            }
        }
    }

}
