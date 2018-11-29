import java.util.Random;

// --------------------------------

// ----------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 23, 2018
 */
public class SkipList {
    private SkipNode head;
    private int level;
    private int size;
    static private Random ran = new Random(); // Hold the Random class object


    /**
     * Constructor
     */
    public SkipList() {
        head = new SkipNode(null, null, 0);
        level = -1;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Finds an object in the SkipList
     *
     * @param key
     *            The key of the SkipList
     * @return
     *         The found Object or not_found
     */
    public Object find(Comparable key) {
        SkipNode x = this.getHead(); // Dummy header node
        for (int i = this.getLevel(); i >= 0; i--) {
            while ((x.getForward()[i] != null) && (x.getForward()[i].getKey()
                .compareTo(key) < 0)) { // go forward
                x = x.getForward()[i]; // Go one last step
            }
        }
        x = x.getForward()[0]; // Move to actual record, if it exists
        if ((x != null) && (x.getKey().compareTo(key) == 0)) {
            return x.getValue(); // Got it
        }
        else {
            return "not_found"; // Its not there
        }
    }


    /**
     * Inserts objects into the SkipList
     * 
     * @param key
     *            The key
     * @param elem
     *            The value
     */
    public void insert(Comparable key, Object elem) {
        int newLevel = randomLevel(); // New node's level
        if (newLevel > this.getLevel()) { // If new node is deeper
            adjustHead(newLevel);
        }
        // Track end of level
        SkipNode[] update = new SkipNode[this.getLevel() + 1];
        SkipNode x = this.getHead(); // Start at header node
        for (int i = this.getLevel(); i >= 0; i--) { // Find insert position
            while ((x.getForward()[i] != null) && (x.getForward()[i].getKey()
                .compareTo(key) < 0)) {
                x = x.getForward()[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode(key, elem, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who points to x
        }
        this.setSize(this.getSize() + 1); // Increment dictionary size
    }


    /**
     * Adjusts the head of the Skiplist
     * 
     * @param newLevel
     *            The new level
     */
    private void adjustHead(int newLevel) {
        SkipNode temp = this.getHead();
        this.setHead(new SkipNode(null, null, newLevel));
        for (int i = 0; i <= this.getLevel(); i++) {
            // Error will happen here
            this.getHead().getForward()[i] = temp.getForward()[i];
        }
        this.setLevel(newLevel);
    }


    /**
     * Generates the level
     * 
     * @return
     *         The generated level
     */
    int randomLevel() {
        int lev;
        int a = 0;
        for (lev = 0; Math.abs(ran.nextInt()) % 2 == 0; lev++) {

            // Do nothing
        }
        if (a == 0) {
            return lev;
        }
        return lev;
    }


    /**
     * Deletes an object from the SkipList
     * 
     * @param key
     *            The key of the deleted item
     */
    public void delete(Comparable key) {
        SkipNode[] update = new SkipNode[this.getLevel() + 1];
        SkipNode x = this.getHead();
        for (int i = this.getLevel(); i >= 0; i--) {
            while ((x.getForward()[i] != null) && (x.getForward()[i].getKey()
                .compareTo(key) < 0)) {
                x = x.getForward()[i];
            }
            update[i] = x;
        }
        x = x.getForward()[0];
        if ((x != null) && (x.getKey().compareTo(key) == 0)) {
            // rearrange ptrs
            for (int i = 0; i <= this.getLevel(); i++) {
                if (update[i].getForward()[i] != x) {
                    break;
                }
                update[i].getForward()[i] = x.getForward()[i];
            }
            // remove levels with no elem
            while (this.getLevel() > 0 && this.getHead().getForward()[this
                .getLevel()] == null) {
                this.setLevel(this.getLevel() - 1);
            }
            this.setSize(this.getSize() - 1);
        }
    }


    /**
     * Prints out the SkipList
     */
    public void print() {
        System.out.println("SkipList dump:");
        SkipNode x = this.getHead();
        System.out.println("Node has depth " + Integer.toString(x.getLevel())
            + ", Value (null)");
        while (x.getForward()[0] != null) {
            x = x.getForward()[0];
            String toPrint = "";
            toPrint += "Node has depth ";
            toPrint += Integer.toString(x.getLevel());
            toPrint += ", Value (";
            toPrint += x.getValue().toString();
            toPrint += ")";
            System.out.println(toPrint);
        }
        System.out.println(Integer.toString(this.getSize())
            + " skiplist nodes printed");
    }


    /**
     * Prints out SkipList items in range
     * 
     * @param start
     *            Starting entry
     * @param end
     *            Ending entry
     */
    public void rangePrint(Comparable start, Comparable end) {
        if (start.compareTo(end) > 0) {
            System.out.println("Error in rangeprint parameters: |" + start
                + "| is not less than |" + end + "|");
        }
        else {
            System.out.println("Found these records in the range |" + start
                + "| to |" + end + "|");
            SkipNode x = this.getHead();
            while (x.getForward()[0] != null) {
                x = x.getForward()[0];
                if (start.compareTo(x.getKey()) <= 0 && end.compareTo(x
                    .getKey()) >= 0) {
                    System.out.println(x.getValue().toString());
                }
            }
        }
    }


    /**
     * Getter for the head
     * 
     * @return
     *         the head
     */
    public SkipNode getHead() {
        return this.head;
    }


    /**
     * Setter for the head
     * 
     * @param head
     *            the head
     */
    public void setHead(SkipNode head) {
        this.head = head;
    }


    /**
     * Getter for the level
     * 
     * @return
     *         the level
     */
    public int getLevel() {
        return level;
    }


    /**
     * Setter for the level
     * 
     * @param level
     *            The level
     */
    public void setLevel(int level) {
        this.level = level;
    }


    /**
     * Getter for the size
     * 
     * @return
     *         the size
     */
    public int getSize() {
        return size;
    }


    /**
     * Setter for the size
     * 
     * @param size
     *            the size
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Getter for the ran
     * 
     * @return
     *         the ran
     */
    public static Random getRan() {
        return ran;
    }


    /**
     * Setter for the ran
     * 
     * @param ran
     *            the ran
     */
    public static void setRan(Random ran) {
        SkipList.ran = ran;
    }

}
