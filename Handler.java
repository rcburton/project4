/**
 * The class containing the Handler.
 *
 * @author Ryan Burton and Sayan Ray
 * @version 11/25/18
 */
public class Handler {

    private SkipList skipList;


    /**
     * Constructor
     * 
     * @param skipList
     *            The SkipList being used by the Handler
     */
    public Handler(SkipList skipList) {
        this.skipList = skipList;
    }


    /**
     * Handles the parsedData and calls the data structure functions
     * 
     * @param parsedData
     *            The data parsed by the Parser
     */
    public void handleCommands(String[] parsedData) {
        if (parsedData[0].equals("add")) {
            Item newItem = new Item(parsedData);
            this.insert(newItem);
        }
        else if (parsedData[0].equals("delete")) {
            this.delete(parsedData[1]);
        }
        else if (parsedData[0].equals("print")) {
            this.print(parsedData);
        }
        else if (parsedData[0].equals("rangeprint")) {
            this.rangeprint(parsedData);

        }
        /*
         * else if (parsedData[0].equals("collisions")) {
         * 
         * }
         * else if (parsedData[0].equals("intersect")) {
         * 
         * }
         */
    }


    /**
     * Inserts a new object into the SkipList and BinTree
     * 
     * @param newItem
     *            The Item being inserted
     */
    public void insert(Item newItem) {
        if (this.getSkipList().find(newItem.getName()).equals("not_found")) {
            if (this.validObject(newItem) == 0) {
                this.getSkipList().insert(newItem.getName(), newItem);
                System.out.println(newItem.getName()
                    + " has been added to the database");
            }
            else if (this.validObject(newItem) == 1) {
                System.out.println("Bad box (" + Integer.toString(newItem
                    .getAirObj().getXorig()) + " " + Integer.toString(newItem
                        .getAirObj().getYorig()) + " " + Integer.toString(
                            newItem.getAirObj().getZorig()) + " " + Integer
                                .toString(newItem.getAirObj().getXwidth()) + " "
                    + Integer.toString(newItem.getAirObj().getYwidth()) + " "
                    + Integer.toString(newItem.getAirObj().getZwidth())
                    + "). All widths must be positive.");

            }
            else if (this.validObject(newItem) == 3) {
                System.out.println("Bad box (" + Integer.toString(newItem
                    .getAirObj().getXorig()) + " " + Integer.toString(newItem
                        .getAirObj().getYorig()) + " " + Integer.toString(
                            newItem.getAirObj().getZorig()) + " " + Integer
                                .toString(newItem.getAirObj().getXwidth()) + " "
                    + Integer.toString(newItem.getAirObj().getYwidth()) + " "
                    + Integer.toString(newItem.getAirObj().getZwidth())
                    + "). All boxes must be entirely within the world box.");

            }
        }
        else {
            System.out.println("Duplicate object names not permitted: |"
                + newItem.getName() + "|");
        }

    }


    /**
     * Deletes objects from the data structures
     * 
     * @param del
     *            The name of the object being deleted
     */
    public void delete(String del) {
        Object temp = this.getSkipList().find(del);
        if (!temp.equals("not_found")) {
            this.getSkipList().delete(del);
            System.out.println("Deleted |" + del + "| from the database");
        }
        else {
            System.out.println("Object |" + del + "| not in the database");
        }

    }


    /**
     * Prints objects in the data structures
     * 
     * @param parsedData
     *            The data parsed by the Parser
     */
    public void print(String[] parsedData) {
        if (parsedData[1].equals("skiplist")) {
            this.getSkipList().print();
        }
        else if (parsedData[1].equals("object")) {
            Object temp = this.getSkipList().find(parsedData[2]);
            if (!temp.equals("not_found")) {
                System.out.println("Found: " + this.getSkipList().find(
                    parsedData[2]).toString());
            }
            else {
                System.out.println("|" + parsedData[2]
                    + "| does not exist in the database");
            }

        }
    }


    /**
     * Prints the objects within the range
     * 
     * @param parsedData
     *            The data parsed by the Parser
     */
    public void rangeprint(String[] parsedData) {
        this.getSkipList().rangePrint(parsedData[1], parsedData[2]);
    }


    /**
     * Checks if the new object is valid
     * 
     * @param newItem
     *            The potential new insertion
     * @return
     *         The error code
     */
    public int validObject(Item newItem) {
        // Negative Widths
        if ((newItem.getAirObj().getXwidth() < 0) || (newItem.getAirObj()
            .getYwidth() < 0) || (newItem.getAirObj().getZwidth() < 0)) {
            return 1;
        }
        // Negative Origins
        else if ((newItem.getAirObj().getXorig() < 0) || (newItem.getAirObj()
            .getYorig() < 0) || (newItem.getAirObj().getZorig() < 0)) {
            return 2;
        }
        // Out of Bounds
        else if (((newItem.getAirObj().getXorig() + newItem.getAirObj()
            .getXwidth()) > 1024) || ((newItem.getAirObj().getYorig() + newItem
                .getAirObj().getYwidth()) > 1024) || ((newItem.getAirObj()
                    .getZorig() + newItem.getAirObj().getZwidth()) > 1024)) {
            return 3;
        }

        return 0;
    }


    /**
     * Getter for the SkipList
     * 
     * @return
     *         The SkipList
     */
    public SkipList getSkipList() {
        return skipList;
    }


    /**
     * Setter for the SkipList
     * 
     * @param skipList
     *            The SkipList
     */
    public void setSkipList(SkipList skipList) {
        this.skipList = skipList;
    }

}
