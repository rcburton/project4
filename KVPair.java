// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 23, 2018
 */
public class KVPair {
    private Comparable key;
    private Object value;


    // ----------------------------------------------------------
    /**
     * Create a new KVPair object.
     *
     * @param key
     *            The key of the KVPair
     * @param elem
     *            The value of the KVPair
     */
    public KVPair(Comparable key, Object elem) {
        this.key = key;
        this.value = elem;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the Value
     *
     * @return
     *         The value
     */
    public Object getValue() {
        return this.value;
    }
    // ~ Fields ................................................................


    // ----------------------------------------------------------
    /**
     * Getter for the key
     *
     * @return
     *         The key
     */
    public Comparable getKey() {
        return this.key;
    }

}
