/**
 * The class containing the Parser.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class SkipNode {
    private KVPair rec;
    private SkipNode[] forward;
    private int level;


    /**
     * Getter for the value
     * 
     * @return
     *         the value
     */
    public Object getValue() {
        return rec.getValue();
    }


    /**
     * Getter for the key
     * 
     * @return
     *         the key
     */
    public Comparable getKey() {
        return rec.getKey();
    }


    /**
     * Getter for the level
     * 
     * @return
     *         the level
     */
    public int getLevel() {
        return this.level;
    }


    /**
     * Constructor
     * 
     * @param key
     *            The key
     * @param elem
     *            The value
     * @param level
     *            The level
     */
    public SkipNode(Comparable key, Object elem, int level) {
        rec = new KVPair(key, elem);
        setForward(new SkipNode[level + 1]);
        for (int i = 0; i < level; i++) {
            getForward()[i] = null;
        }
        this.level = level;
    }


    /**
     * Writes the data as a String
     * 
     * @return
     *         the String
     */
    public String toString() {
        return rec.toString();
    }


    /**
     * Get the current value of forward.
     *
     * @return The value of forward for this object.
     */
    public SkipNode[] getForward() {
        return forward;
    }


    /**
     * Set the value of forward for this object.
     *
     * @param forward
     *            The new value for forward.
     */
    public void setForward(SkipNode[] forward) {
        this.forward = forward;
    }


    /**
     * Getter for the rec
     * 
     * @return
     *         the rec
     */
    public KVPair getRec() {
        return rec;
    }


    /**
     * Setter for the rec
     * 
     * @param rec
     *            the rec
     */
    public void setRec(KVPair rec) {
        this.rec = rec;
    }


    /**
     * Setter for the level
     * 
     * @param level
     *            the level
     */
    public void setLevel(int level) {
        this.level = level;
    }

}
