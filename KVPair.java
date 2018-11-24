// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author sayanray
 * @version Nov 23, 2018
 */
public class KVPair
{
    private Comparable key;
    private Object     value;


    // ----------------------------------------------------------
    /**
     * Create a new KVPair object.
     *
     * @param key
     * @param elem
     */
    public KVPair(Comparable key, Object elem)
    {
        this.key = key;
        this.value = elem;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @return
     */
    public Object value()
    {
        return this.value;
    }
    // ~ Fields ................................................................


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @return
     */
    public Comparable key()
    {
        return this.key;
    }


}
